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
        '$state',
        'genericUtilService',        
        '${entityNameVariable}Resource',
        '${entityNameMasterVariable}MainService',
        'searchConfigOptionsService',
        'dateUtilService'
    ];

    function ${entityNameVariable}Service(
        $state,
        genericUtilService,        
        ${entityNameVariable}Resource,
        ${entityNameMasterVariable}MainService,
        searchConfigOptionsService,
        dateUtilService
    ) {
        var self = this;
        var listingConfig;
        var getModel = ${entityNameMasterVariable}MainService.getModel;

        self.getTabConfig = getTabConfig;
        self.getListingData = getListingData;

        activate();

        function getTabConfig() {
            var tab = new DcGenericCrudTabForm();
            tab.label('${model.entityName}');
            tab.fields(getFormFields());
            tab.modelProperty('${entityNameVariable}');
            tab.listingConfig(listingConfig);
            tab.deleteCallbackSuccess(function () {
                $state.reload();
            });
            return tab.toJSON();
        }

        function getListingData() {
            return listingConfig.data;
        }

        /////////////

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
                    .minSearchLength(0)                    
                    </#if>
                    .toJSON()
                <#if attribute?has_next>
                ,
                </#if>                    
				</#list>               
            ];
        }

        function setUpListingConfig() {
            var listingConfigObj = new DcGenericListing();
            listingConfigObj.callFnOnStart(true);
            listingConfigObj.pageChangeCallbackFn(find${entityName});
            listingConfigObj.columnsConfig(getListingColumnsConfig());
            listingConfig = listingConfigObj.toJSON();
        }

        function find${entityName}(params) {
            params = params || {};
            params.parentId = genericUtilService.getUrlId();
            return ${entityNameMaster}Resource.getPaged(params, function (data) {
                listingConfig.data = data.items;
            });
        }

        function isRecordLoaded() {
            return getModel().${entityNameMaster}.id;
        }

        function getListingColumnsConfig() {
            return new DcGenericListingColumnsConfig(getListingColumnsConfigData()).toJSON();
        }

        function getListingColumnsConfigData() {
            return [                
                <#list model.attributes as attribute>		
                	<#if attribute.entity>
                	new DcGenericListingColumnConfigData('Código', '${attribute.name?cap_first}.codigo').toJSON(),
                	new DcGenericListingColumnConfigData('Descrição', '${attribute.name?cap_first}.descricao').toJSON()
                	<#elseif attribute.date>
                	new DcGenericListingColumnConfigData('${attribute.label}', '${attribute.name?cap_first}').mask({ filter: 'date', exp: '<#if attribute.mask != null>${attribute.mask}<#else>dd/MM/yyyy HH:mm:ss</#if>' }).toJSON()               	
                	<#else>
                	new DcGenericListingColumnConfigData('${attribute.label}', '${attribute.name?cap_first}').toJSON()
                	</#if>
                    <#if attribute?has_next>,</#if>                    
				</#list>  
            ]
        }



        function activate() {
            setUpListingConfig();
        }

        function getFilterSearchOptions(type) {
			return searchConfigOptionsService.from(type);
        }
    }
})();