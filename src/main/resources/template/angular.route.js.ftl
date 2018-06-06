<#assign entityName = class.entityName>
<#assign entityNameVariable = class.entityName?uncap_first>
<#assign module = class.moduleName?lower_case>

(function () {
    'use strict';

    angular
        .module('cw.${module}.${entityNameVariable}')
        .run(${entityNameVariable}RouteRun);

        ${entityNameVariable}RouteRun.$inject = [
        'routerHelper',
        '${entityNameVariable}RouteConstants'
    ];

    function ${entityNameVariable}RouteRun(
        routerHelper,
        ${entityNameVariable}RouteConstants
    ) {
        routerHelper.configureStates(${entityNameVariable}RouteConstants);
    }
})();