<#assign className = class.className>
<#assign variableName = class.entityName?lower_case>
<#assign module = class.moduleBasic?lower_case>
<#assign company = class.company.packageName>
package ${class.package};

import java.util.List;

import com.${company}.cooperate.${module}.common.entities.${class.entityName};
import com.${company}.cooperate.${module}.server.eao.${class.entityName}EAO;
import com.${company}.cooperate.${module}.server.eao.${module?cap_first}EAO;
import com.datacoper.arquitetura.common.DCContextShared;
import com.datacoper.cooperate.arquitetura.common.exception.DCLogicException;
import com.datacoper.cooperate.nucleo.server.gerenciador.AbstractDetailCRUD;
import com.datacoper.cooperate.nucleo.server.gerenciador.AbstractMasterCRUD;
<#list class.imports as import>
import ${import};
</#list>

public class ${className} extends AbstractMasterCRUD<${class.entityName}, Void> {
    
    <#include "defaultConstructor.ftl">

    private ${class.entityName}Validador validator = new ${class.entityName}Validador();

    @Override
    protected ${class.entityName}EAO getGenericEAO() {
        return new ${module?cap_first}EAO().get${class.entityName}EAO();
    }

    @Override
    protected void addDetailsManager(List<AbstractDetailCRUD<?, ${class.entityName}, Void>> detailsManager) { }

    @Override
    protected void validate(${class.entityName} ${variableName}, DCContextShared contextShared, Void parameters) throws DCLogicException {
        
    }

    @Override
    protected void validateRequiredFields(${class.entityName} ${variableName}) throws DCLogicException {
        validator.requiredFields(${variableName});
    }
}