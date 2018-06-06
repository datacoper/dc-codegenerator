<#assign entityName = class.entityName>
<#assign entityNameVariable = class.entityName?uncap_first>
<#assign module = class.moduleName?lower_case>

(function () {
    'use strict';

    angular
        .module('cw.${module}.${entityNameVariable}')
        .controller('${entityNameVariable}Controller', ${entityNameVariable}Controller);

    ${entityNameVariable}Controller.$inject = [
        '${entityNameVariable}MainService',
        //'${entityNameVariable}DetailService',        
    ];

    function ${entityNameVariable}Controller(
        ${entityNameVariable}MainService,
        //${entityNameVariable}DetailService,        
    ) {

        /**
         * Registro das details do case
         *
         * @returns {*}
         */
        function getTabs() {
            var tabs = new DcTabs();
            //var ${entityNameVariable}DetailTab = ${entityNameVariable}DetailService.getTabConfig();
            //tabs.setTab(${entityNameVariable}DetailTab);
            return tabs.toJSON();
        }


        /***************************************
         * Funções Genericas
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
            //formFieldsConfig.tabs(getTabs());
            return formFieldsConfig.toJSON();
        }

        function activate() {
            setUpGenericCrudConfig();
        }
    }
})();