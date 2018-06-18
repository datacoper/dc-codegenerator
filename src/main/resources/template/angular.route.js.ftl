<#assign entityName = model.entityName>
<#assign entityNameVariable = model.entityName?uncap_first>
<#assign module = model.modulePackageName>

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