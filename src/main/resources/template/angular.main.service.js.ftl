<#assign entityName = class.entityName>
<#assign entityNameVariable = class.entityName?uncap_first>
<#assign module = class.moduleName?lower_case>

(function () {
    'use strict';

    angular
        .module('cw.${module}.${entityNameVariable}')
        .service('${entityNameVariable}MainService', ${entityNameVariable}MainService);

    ${entityNameVariable}MainService.$inject = [
        '${entityNameVariable}Resource'
    ];

    function ${entityNameVariable}MainService(
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
                <#list class.attributes as attribute>		
                new DcGenericCrudField('${attribute.type}', '${attribute.label}', 12, '${attribute.name?uncap_first}')
                    //.disable(false)
                    //.maxlength(6)
                    //.max(6)
                    //.min(6)
                    //.onlyWhenNew(false)
                    //.require(true)
                    //.dateFormat('dd/MM/yyyy HH:mm:ss')
                    .toJSON()<#if attribute?has_next>,</#if>
				</#list>               
            ];
        }

        /***************************************
         * Funcoes Genericas
         ***************************************/
        var vm = this;
        var model = { main: { ativo: true } };

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