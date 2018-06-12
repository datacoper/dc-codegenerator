<#assign entityName = model.entityName>
<#assign entityNameVariable = model.entityName?uncap_first>
<#assign module = model.moduleName?lower_case>

(function () {
    'use strict';

    angular.module('cw.${module}.${entityNameVariable}', []);
})();