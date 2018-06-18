<#assign className = model.className>
<#assign company = model.company.packageName>
<#assign module = model.modulePackageName>
package ${model.package};

import com.datacoper.cooperate.arquitetura.common.services.MasterCrudService;
import ${model.entityType};

public interface ${className} extends MasterCrudService<${model.entityName}>{


}