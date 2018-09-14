<#assign entityName = model.entityName>
<#assign entityNameVariable = model.entityName?uncap_first>
<#assign module = model.moduleName?uncap_first>

(function () {
    'use strict';

    angular
        .module('cw.${module}.${entityNameVariable}')
        .controller('${entityNameVariable}Controller', ${entityNameVariable}Controller);

    ${entityNameVariable}Controller.$inject = [
        <#list model.details as detail>
        '${detail.entityName?cap_first}Service',
        </#list>
        '${entityNameVariable}MainService'
                
    ];

    function ${entityNameVariable}Controller(
        <#list model.details as detail>
        ${detail.entityName?cap_first}Service,
        </#list>
        ${entityNameVariable}MainService                
    ) {

        <#if model.hasDetails()>
        function getTabs() {
            var tabs = new DcTabs();            
            <#list model.details as detail>
            tabs.setTab(${detail.entityName?uncap_first}Service.getTabConfig());
            </#list>
            return tabs.toJSON();
        }
		</#if>

        /***************************************
         * Funcoes Genericas
         ***************************************/
        var vm = this;
        var genericCrudConfig = new DcGenericCrud();

        vm.genericCrudConfig = genericCrudConfig;

        activate();

        function setUpGenericCrudConfig() {
            genericCrudConfig.model(${entityNameVariable}MainService.getModel());
            genericCrudConfig.formFieldsConfig(getFormFieldsConfig());
            genericCrudConfig.toJSON();
        }

        function getFormFieldsConfig() {
            var formFieldsConfig = new DcGenericCrudFormConfig();
            formFieldsConfig.main(${entityNameVariable}MainService.getFormConfig());
          	<#if model.hasDetails()>
          	formFieldsConfig.tabs(getTabs());
          	</#if>
            return formFieldsConfig.toJSON();
        }

        function activate() {
            setUpGenericCrudConfig();
        }
    }
})();
