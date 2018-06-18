<#assign entityName = model.entityName>
<#assign entityNameVariable = model.entityName?uncap_first>
<#assign module = model.modulePackageName>

(function () {
    'use strict';

    angular.module('cw.${module}.${entityNameVariable}', []);
})();