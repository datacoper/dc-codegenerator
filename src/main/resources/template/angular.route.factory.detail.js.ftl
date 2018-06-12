<#assign entityName = class.entityName>
<#assign entityNameVariable = class.entityName?uncap_first>
<#assign module = class.moduleName?lower_case>

(function () {
    'use strict';

    angular
        .module('cw.${module}.${entityNameVariable}')
        .factory('${entityNameVariable}RouteConstants', ${entityNameVariable}RouteConstants);

    ${entityNameVariable}RouteConstants.$inject = [
        'apiService'
    ];

    function ${entityNameVariable}RouteConstants(
        apiService
    ) {
        return {
            '${entityNameVariable}': {
                state: '${module[0..2]?upper_case}.${entityNameVariable}',
                config: {
                	//alterar o camelcase por - ex: pacoteVenda por pacote-vendas 
                    url: '/${entityNameVariable}',
                    templateUrl: '${module}/${entityNameVariable}/${entityNameVariable}.html',
                    resolve: {
                        loadDependencies: ['loadModulesService', function (loadModulesService) {
                            return loadModulesService.loadFiles(getDependencies());
                        }]
                    }
                }
            },
            'createEdit': {
                state: '${module[0..2]?upper_case}.${entityNameVariable}.createEdit',
                config: apiService.getRouteConfig('genericCrudCreateEdit')
            }
        };

        function getDependencies() {
            return [
                '${module}/${entityNameVariable}/${entityNameVariable}.min.js',
                //'${module}/${entityNameVariable}/${entityNameVariable}Detail/${entityNameVariable}Detail.min.js',                
                '${module}/${module}Resource/${module}Resource.min.js'
            ];
        }
    }
})();