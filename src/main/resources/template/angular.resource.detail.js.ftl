<#assign entityName = model.entityName>
<#assign entityNameVariable = entityName?uncap_first>
<#assign module = model.modulePackageName>
<#assign entityNameMaster = model.entityNameMaster>
<#assign entityNameMasterVariable = entityNameMaster?uncap_first>

(function () {
    'use strict';

    angular
        .module('cw.${module}')
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
        var path = '/${entityNameMasterVariable}/:parentId/${entityName?lower_case}/:id';

        var url = baseUrl + path;

        var config = {
            //getPaged: { method: 'GET', url: url + '/paged' }
        };

        return RESTFulHelperFactory.configureRESTFulResource(url, config);
    }
})();