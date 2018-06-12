<#assign entityName = class.entityName>
<#assign entityNameVariable = class.entityName?uncap_first>
<#assign module = class.moduleName?lower_case>

(function () {
    'use strict';

    angular
        .module('cw.${module}.${entityNameVariable}')
        .factory('${entityNameVariable}Resource', ${entityNameVariable}Resource);

    ${entityNameVariable}Resource.$inject = [
        'RESTFulHelperFactory',
        'apiService'
    ];

    function ${entityNameVariable}Resource(
        RESTFulHelperFactory,
        apiService
    ) {
        var baseUrl = apiService.getApi('${module}').baseUrl;
        var path = '/${entityName?lower_case}/:id';
        var url = baseUrl + path;

        return RESTFulHelperFactory.configureRESTFulResource(url);
    }
})();
