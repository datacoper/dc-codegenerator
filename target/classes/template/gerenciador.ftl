<#assign className = class.className>
<#assign variableName = class.classNameBasic?lower_case>
<#assign module = class.moduleBasic?lower_case>
<#assign company = class.company.packag>
package ${class.package};

import java.util.List;

import com.${company}.cooperate.${module}.common.entities.${class.classNameBasic};
import com.${company}.cooperate.${module}.server.eao.${class.classNameBasic}EAO;
import com.${company}.cooperate.${module}.server.eao.${module?cap_first}EAO;
import com.datacoper.arquitetura.common.DCContextShared;
import com.datacoper.cooperate.arquitetura.common.exception.DCLogicException;
import com.datacoper.cooperate.nucleo.server.gerenciador.AbstractDetailCRUD;
import com.datacoper.cooperate.nucleo.server.gerenciador.AbstractMasterCRUD;
<#list class.imports as import>
import ${import};
</#list>

public class ${className} extends AbstractMasterCRUD<${class.classNameBasic}, Void> {
    
    <#include "defaultConstructor.ftl">

    private ${class.classNameBasic}Validador validator = new ${class.classNameBasic}Validador();

    @Override
    protected ${class.classNameBasic}EAO getGenericEAO() {
        return new ${module?cap_first}EAO().get${class.classNameBasic}EAO();
    }

    @Override
    protected void addDetailsManager(List<AbstractDetailCRUD<?, ${class.classNameBasic}, Void>> detailsManager) { }

    @Override
    protected void validate(${class.classNameBasic} ${variableName}, DCContextShared contextShared, Void parameters) throws DCLogicException {
        
    }

    @Override
    protected void validateRequiredFields(${class.classNameBasic} ${variableName}) throws DCLogicException {
        validator.requiredFields(${variableName});
    }
}