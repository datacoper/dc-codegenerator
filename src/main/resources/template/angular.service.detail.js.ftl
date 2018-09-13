<#assign entityName = model.entityName>
<#assign entityNameVariable = entityName?uncap_first>
<#assign module = model.moduleName?uncap_first>
<#assign entityNameMaster = model.entityNameMaster>
<#assign entityNameMasterVariable = entityNameMaster?uncap_first>

(function () {
    'use strict';

    angular
        .module('cw.${module}.${entityNameMasterVariable}')
        .service('${entityNameVariable}Service', ${entityNameVariable}Service);

    ${entityNameVariable}Service.$inject = [
        'genericUtilService',
        '${entityNameVariable}Resource',
        '${entityNameMasterVariable}MainService',
        'searchConfigOptionsService',
        'dateUtilService'
    ];

    function ${entityNameVariable}Service(
        genericUtilService,
        ${entityNameVariable}Resource,
        ${entityNameMasterVariable}MainService,
        searchConfigOptionsService,
        dateUtilService
    ) {
        // Váriaveis
        var labelDetail = '${model.entityName}';
        var modelProperty = '${entityNameVariable}';
        var getModel = ${entityNameMasterVariable}MainService.getModel;
        var resource = ${entityNameVariable}Resource;

        /**
         * Configuração de listagem dos filhos
         *
         * @returns {*[]}
         */
        function getListingColumnsConfigData() {
            return [
                <#list model.attributes as attribute>
                	<#if attribute.entity>
                	new DcGenericListingColumnConfigData('Código', '${attribute.name?cap_first}.codigo').toJSON(),
                	new DcGenericListingColumnConfigData('Descrição', '${attribute.name?cap_first}.descricao').toJSON()
                	<#elseif attribute.date>
                	new DcGenericListingColumnConfigData('${attribute.label}', '${attribute.name?cap_first}').mask({ filter: 'date', exp: '<#if attribute.mask??>${attribute.mask}<#else>dd/MM/yyyy HH:mm:ss</#if>' }).toJSON()
                	<#else>
                	new DcGenericListingColumnConfigData('${attribute.label}', '${attribute.name?cap_first}').toJSON()
                	</#if>
                    <#if attribute?has_next>,</#if>
				</#list>
            ]
        }

        /**
         * Configuração de campos do form
         *
         * @returns {*[]}
         */
        function getFormFields() {
            return [
                <#list model.attributes as attribute>
                new DcGenericCrudField('${attribute.frontType}', '${attribute.label}', 12, '${attribute.name?uncap_first}')
                    .require(<#if attribute.required>true<#else>false</#if>)
                    <#if attribute.number>
                    //.min(${attribute.scale})
                    //.max(${attribute.scale})
                    <#if attribute.scale gt 0 >
                    .decimalPlaces(${attribute.scale})
                    </#if>
                    </#if>
                    .disable(<#if attribute.updatable>false<#else>true</#if>)
                    <#if attribute.text>
                    .maxlength(${attribute.precision})
                    </#if>
                    //.onlyWhenNew(false)
                    <#if attribute.date>
                    .dateFormat('<#if attribute.mask??>${attribute.mask}<#else>dd/MM/yyyy</#if>')
                    </#if>
                    <#if attribute.entity>
                    //.filterSearchOptions(getFilterSearchOptions())
                    .resourceName('${attribute.name?uncap_first}Resource')
                    //.methodName('getAtivos')
                    //.resourceParamsFn(function () {
                    //    return { variable: getModel().variable}
                    //})
                    .minSearchLength(0)
                    </#if>
                    .toJSON()
                <#if attribute?has_next>
                ,
                </#if>
				</#list>
            ];
        }

        /***************************************
         * Funções Genericas
         ***************************************/
        var self = this;
        var listingConfig;

        self.getTabConfig = getTabConfig;

        activate();

        function getTabConfig() {
            var tab = new DcGenericCrudTabForm();

            tab.label(labelDetail);
            tab.fields(getFormFields());
            tab.modelProperty(modelProperty);
            tab.listingConfig(listingConfig);
            tab.saveFn(saveRequest);
            tab.editRequestFn(editRequest);
            tab.deleteFn(deleteRequest);

            return tab.toJSON();
        }

        ///////////////////////

        function saveRequest(detail) {
            var payload = angular.copy(detail);

            var params = {
                parentId: genericUtilService.getUrlId()
            };

            return resource.saveOrUpdate(params, payload);
        }

        function editRequest(detail) {
            var params = {
                parentId: genericUtilService.getUrlId(),
                id: detail.id
            };
            return resource.get(params);
        }

        function deleteRequest(detail) {
            var payload = {
                parentId: genericUtilService.getUrlId(),
                id: detail.id
            };

            return resource.delete(payload);
        }

        function setUpListingConfig() {
            var listingConfigObj = new DcGenericListing();
            listingConfigObj.callFnOnStart(true);
            listingConfigObj.pageChangeCallbackFn(pageChangeCallbackFn);
            listingConfigObj.columnsConfig(getListingColumnsConfig());
            listingConfig = listingConfigObj.toJSON();
        }

        function pageChangeCallbackFn(params) {
            params = params || {};
            params.parentId = genericUtilService.getUrlId();

            return resource.query(params, function (data) {
                listingConfig.data = data;
            });
        }

        function getListingColumnsConfig() {
            return new DcGenericListingColumnsConfig(getListingColumnsConfigData()).toJSON();
        }

        function getFilterSearchOptions(type) {
            return searchConfigOptionsService.from(type);
        }

        function activate() {
            setUpListingConfig();
        }

    }
})();