<#assign entityName = model.entityName>
<#assign entityNameVariable = entityName?uncap_first>
<#assign module = model.moduleName?lower_case>
<#assign entityNameMaster = model.entityNameMaster>
<#assign entityNameMasterVariable = entityNameMaster?uncap_first>

(function () {
    'use strict';

    angular
        .module('cw.${module}.${entityNameMasterVariable}')
        .service('${entityNameMaster}Service', ${entityNameMaster}Service);

    ${entityNameMaster}Service.$inject = [
        '$state',
        'genericUtilService',
        'produtoResource',
        '${entityNameMaster}Resource',
        '${entityNameMasterVariable}MainService',
        'searchConfigOptionsService',
        'dateUtilService'
    ];

    function ${entityNameMaster}Service(
        $state,
        genericUtilService,
        produtoResource,
        ${entityNameMaster}Resource,
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
            tab.modelProperty('${entityNameMaster}');
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

                new DcGenericCrudField('calculatedField', 'Conta de Estoque', 12, 'contaDeEstoque')
                    .filterSearchOptions(getFilterSearchOptions())
                    .require(isNewRegister)
                    .disable(isRecordLoaded)
                    .resourceName('contaDeEstoqueFaturamentoResource')
                    .minSearchLength(0)
                    .toJSON(),

                new DcGenericCrudField('calculatedField', 'Produto', 6, 'produto')
                    .filterSearchOptions(getFilterSearchOptions())
                    .disable(isRecordLoaded)
                    .toJSON(),

                new DcGenericCrudField('vigencia', null, 6)
                    .dateFormat('dd/MM/yyyy HH:mm:ss')
                    .requireInicio(true)
                    .toJSON()
            ]
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

        function isNewRegister() {
            return !getModel().${entityNameMaster}.contaDeEstoque && !getModel().${entityNameMaster}.unidadeMedidaProduto;
        }

        function isRecordLoaded() {
            return getModel().${entityNameMaster}.id;
        }

        function getListingColumnsConfig() {
            return new DcGenericListingColumnsConfig(getListingColumnsConfigData()).toJSON();
        }

        function getListingColumnsConfigData() {
            return [
                new DcGenericListingColumnConfigData('Código', 'unidadeMedidaProduto.produto.codigo').toJSON(),
                new DcGenericListingColumnConfigData('Descrição', 'unidadeMedidaProduto.produto.descricao').toJSON(),
                new DcGenericListingColumnConfigData('Sigla', 'unidadeMedidaProduto.sigla').toJSON(),
                new DcGenericListingColumnConfigData('Inicio Vigência', 'inicioVigencia').mask({ filter: 'date', exp: 'dd/MM/yyyy HH:mm:ss' }).toJSON(),
                new DcGenericListingColumnConfigData('Fim Vigência', 'fimVigencia').mask({ filter: 'date', exp: 'dd/MM/yyyy HH:mm:ss' }).toJSON()
            ]
        }



        function activate() {
            setUpListingConfig();
        }

        function getFilterSearchOptions(type) {
            if (type == undefined) {
                return [
                    new DcSearchConfigOption('Código', 'codigo', true).toJSON(),
                    new DcSearchConfigOption('Descrição', 'descricao', true).toJSON()
                ];
            }
            else {
                return searchConfigOptionsService.from(type);
            }
        }
    }
})();