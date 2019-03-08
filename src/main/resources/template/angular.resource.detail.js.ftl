<#assign entityName = model.entityName>
<#assign entityNameVariable = entityName?uncap_first>
<#assign module = model.moduleName?uncap_first>
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
        var baseUrl = apiService.getApi('${module?lower_case}').baseUrl;
        var path = '/${entityNameMasterVariable?lower_case}/:parentId/${entityName?lower_case}/:id';

        var url = baseUrl + path;

        var config = {
            //getXYZ: { method: 'GET', url: url + '/xyz' }
        };

        return RESTFulHelperFactory.configureRESTFulResource(url, config);
    }
})();
