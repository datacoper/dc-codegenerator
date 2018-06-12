<#assign entityNameVariable = model.entityName?uncap_first>
<#assign module = model.moduleName?lower_case>
<#assign entityName = model.entityName>

(function () {
    'use strict';

    angular.module('cw.${module}.${entityNameVariable}', []);
})();