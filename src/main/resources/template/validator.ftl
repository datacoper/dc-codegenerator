<#assign className = class.className>
<#assign module = class.moduleName?lower_case>
<#assign company = class.company.packageName>
package ${class.package};

<<<<<<< HEAD
=======
import com.${company}.cooperate.${module}.common.entities.${class.classNameBasic};
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
import com.datacoper.cooperate.arquitetura.common.util.ValidateMandatoryFields;
import com.${company}.cooperate.${module}.common.entities.${class.entityName};
import com.datacoper.cooperate.nucleo.server.crud.ValidatorGenericCRUD;

public class ${className}  implements ValidatorGenericCRUD<${class.entityName}> {
    
<<<<<<< HEAD
    @Override
	public ValidateMandatoryFields validateRequiredFields(${class.entityName} entity) {
        return new ValidateMandatoryFields()
        <#list class.attributes as attribute>
                .add(${class.entityName?uncap_first}.get${attribute.name?cap_first}(), "${attribute.name}")                        
        </#list>
        ;
=======
    <#include "defaultConstructor.ftl">

    public void validateRequiredFields(${class.classNameBasic} ${class.classNameBasic?uncap_first}) {
        new ValidateMandatoryFields()
        <#list class.attributes as attribute>
                .add(${class.classNameBasic?uncap_first}.get${attribute.name?cap_first}(), "${attribute.alias}")
        </#list>
                .validate();
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
    }
}