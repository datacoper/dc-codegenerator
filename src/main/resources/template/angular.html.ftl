<#assign entityName = class.entityName>
<#assign entityNameVariable = class.entityName?uncap_first>
<#assign module = class.moduleName?lower_case>

<div ng-controller="${entityNameVariable}Controller as ${entityNameVariable}Ctrl">
    <dc-generic-crud actions="CRUD"
                     model="${entityNameVariable}Ctrl.genericCrudConfig.model()"
                     form-fields-config="${entityNameVariable}Ctrl.genericCrudConfig.formFieldsConfig()"
                     resource-name="${entityNameVariable}Resource"
    ></dc-generic-crud>
</div>
    