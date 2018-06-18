<#assign entityName = model.entityName>
<#assign entityNameVariable = model.entityName?uncap_first>
<#assign module = model.modulePackageName>

(function () {
    'use strict';

    angular
        .module('cw.${module}.${entityNameVariable}')
        .service('${entityNameVariable}MainService', ${entityNameVariable}MainService);

    ${entityNameVariable}MainService.$inject = [
        <#list model.attributes as attribute>
        '${attribute.name?cap_first}Resource',
        </#list>
        '${entityNameVariable}Resource'
    ];

    function ${entityNameVariable}MainService(
        <#list model.attributes as attribute>
        ${attribute.name?cap_first}Resource,
        </#list>
        ${entityNameVariable}Resource
    ) {
        // variaveis
        var resource = ${entityNameVariable}Resource;
        var propertyIdName = "id${entityName}";

        /**
         * Configuracao de campos do form principal
         */
        function getFormFields() {
            return [
                <#list model.attributes as attribute>		
                new DcGenericCrudField('${attribute.frontType}', '${attribute.label}', 12, '${attribute.name?uncap_first}')
                    .require(<#if attribute.required>true<#else>false</#if>))                    
                    <#if attribute.number>//.min(${attribute.scale})</#if>
                    <#if attribute.number>//.max(${attribute.scale})</#if>
                    .disable(<#if attribute.updatable>false<#else>true</#if>))
                    <#if attribute.text>.maxlength(${attribute.precision})</#if>
                    <#if attribute.scale gt 0 >.decimalPlaces(${attribute.scale})</#if>
                    //.onlyWhenNew(false)                    
                    <#if attribute.mask??>.dateFormat('${attribute.mask}')</#if>
                    <#if attribute.entity>
                    //.filterSearchOptions(getFilterSearchOptions())                    
                    .resourceName('${attribute.name?uncap_first}Resource')
                    .minSearchLength(0)
                    .toJSON()
                    </#if>
                    <#if attribute?has_next>,</#if>                    
				</#list>               
            ];
        }

        /***************************************
         * Funcoes Genericas
         ***************************************/
        var vm = this;
        var model = {};

        vm.getFormConfig = getFormConfig;
        vm.getModel = getModel;

        function getModel() {
            return model;
        }

        function getFormConfig() {
            var formConfig = new DcGenericCrudMainForm();

            formConfig.getFn(getFn);
            formConfig.saveFn(saveFn);
            formConfig.propertyIdName(propertyIdName);
            formConfig.fields(getFormFields());

            return formConfig.toJSON();
        }

        function getFn(id) {
            return resource.get({ id: id });
        }

        function saveFn() {
            var payload = model.main;
            return resource.saveOrUpdate({ id: payload.id }, payload);
        }

    }
})();