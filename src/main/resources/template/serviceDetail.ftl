<#assign className = class.className>
<#assign company = class.company.packageName>
<#assign module = class.moduleName?lower_case>
package ${class.package};

import com.datacoper.cooperate.arquitetura.common.services.MasterCrudService;
import com.${company}.cooperate.${module}.common.entities.${class.entityName};

public interface ${class.entityName}Service extends MasterCrudService<${class.entityName}>{


}