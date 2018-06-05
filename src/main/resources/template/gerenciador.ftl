<#assign className = class.className>
<#assign variableName = class.classNameBasic?lower_case>
<#assign module = class.moduleBasic>
<#assign company = class.company.packag>
package ${class.package};

import java.util.List;

import com.${company}.cooperate.${module?lower_case}.common.entities.${class.classNameBasic};
import com.${company}.cooperate.${module?lower_case}.server.eao.${class.classNameBasic}EAO;
import com.${company}.cooperate.${module?lower_case}.server.eao.${module?cap_first}EAO;
import com.datacoper.arquitetura.common.DCContextShared;
import com.datacoper.cooperate.arquitetura.common.exception.DCLogicException;
import com.datacoper.cooperate.nucleo.server.gerenciador.AbstractDetailCRUD;
import com.datacoper.cooperate.nucleo.server.gerenciador.AbstractMasterCRUD;
<#list class.imports as import>
import ${import};
</#list>

public class ${className} extends AbstractMasterCRUD<${class.classNameBasic}, Void> {
    
    <#include "defaultConstructor.ftl">

    private Validador${class.classNameBasic} validador = new Validador${class.classNameBasic}();

    @Override
    protected ${class.classNameBasic}EAO getGenericEAO() {
        return new ${module}EAO().get${class.classNameBasic}EAO();
    }

    @Override
    protected void addDetailsManager(List<AbstractDetailCRUD<?, ${class.classNameBasic}, Void>> detailsManager) { 

    }

    @Override
    protected void validate(${class.classNameBasic} ${variableName}, DCContextShared contextShared, Void parameters) throws DCLogicException {
        
    }

    @Override
    protected void validateRequiredFields(${class.classNameBasic} ${variableName}) throws DCLogicException {
        validador.validateRequiredFields(${variableName});
    }
}