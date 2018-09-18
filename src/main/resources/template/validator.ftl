<#assign className = model.className>
<#assign module = model.modulePackageName>
<#assign company = model.company.packageName>
package ${model.package};

import com.datacoper.cooperate.arquitetura.common.util.ValidateMandatoryFields;
import com.${company}.cooperate.${module}.common.entities.${model.entityName};
import com.datacoper.cooperate.nucleo.server.crud.ValidatorGenericCRUD;

public class ${className} implements ValidatorGenericCRUD<${model.entityName}> {
    
    @Override
	public ValidateMandatoryFields validateRequiredFields(${model.entityName} entity) {

		ValidateMandatoryFields validateMandatoryFields = new ValidateMandatoryFields();

        <#list model.attributes as attribute>
                <#if attribute.required>
		validateMandatoryFields.add(entity.get${attribute.name?cap_first}(), "${attribute.label}");
                </#if>
        </#list>


		return validateMandatoryFields;
    }
}
