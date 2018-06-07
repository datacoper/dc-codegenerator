<#assign className = class.className>
<#assign module = class.moduleName?lower_case>
<#assign company = class.company.packageName>
package ${class.package};

import com.datacoper.cooperate.arquitetura.common.util.ValidateMandatoryFields;
import com.${company}.cooperate.${module}.common.entities.${class.entityName};
import com.datacoper.cooperate.nucleo.server.crud.ValidatorGenericCRUD;

public class ${className}  implements ValidatorGenericCRUD<${class.entityName}> {
    
    @Override
	public ValidateMandatoryFields validateRequiredFields(${class.entityName} ${class.entityName?uncap_first}) {
        return new ValidateMandatoryFields()
        <#list class.attributes as attribute>
                <#if attribute.required>
                	.add(${class.entityName?uncap_first}.get${attribute.name?cap_first}(), "${attribute.label}")
                </#if>
        </#list>
        ;
    }
}