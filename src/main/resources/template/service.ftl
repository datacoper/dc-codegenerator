<#assign className = model.className>
<#assign company = model.company.packageName>
<#assign module = model.moduleName?lower_case>
package ${model.package};

import com.datacoper.cooperate.arquitetura.common.services.MasterCrudService;
import com.${company}.cooperate.${module}.common.entities.${model.entityName};

public interface ${className} extends MasterCrudService<${model.entityName}>{


}