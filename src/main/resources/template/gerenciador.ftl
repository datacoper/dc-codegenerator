<#assign className = model.className>
<#assign variableName = model.classNameBasic?lower_case>
<#assign module = model.moduleBasic>
<#assign company = model.company.packag>
package ${model.package};

import java.util.List;

import com.${company}.cooperate.${module?lower_case}.common.entities.${model.classNameBasic};
import com.${company}.cooperate.${module?lower_case}.server.eao.${model.classNameBasic}EAO;
import com.${company}.cooperate.${module?lower_case}.server.eao.${module?cap_first}EAO;
import com.datacoper.arquitetura.common.DCContextShared;
import com.datacoper.cooperate.arquitetura.common.exception.DCLogicException;
import com.datacoper.cooperate.nucleo.server.gerenciador.AbstractDetailCRUD;
import com.datacoper.cooperate.nucleo.server.gerenciador.AbstractMasterCRUD;
<#list model.imports as import>
import ${import};
</#list>

public class ${className} extends AbstractMasterCRUD<${model.classNameBasic}, Void> {

    private Validador${model.classNameBasic} validador = new Validador${model.classNameBasic}();

    @Override
    protected ${model.classNameBasic}EAO getGenericEAO() {
        return new ${module}EAO().get${model.classNameBasic}EAO();
    }

    @Override
    protected void addDetailsManager(List<AbstractDetailCRUD<?, ${model.classNameBasic}, Void>> detailsManager) { 

    }

    @Override
    protected void validate(${model.classNameBasic} ${variableName}, DCContextShared contextShared, Void parameters) throws DCLogicException {
        
    }

    @Override
    protected void validateRequiredFields(${model.classNameBasic} ${variableName}) throws DCLogicException {
        validador.validateRequiredFields(${variableName});
    }
}