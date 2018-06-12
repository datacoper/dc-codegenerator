<#assign className = model.className>
<#assign company = model.company.packageName>
<#assign module = model.moduleName?lower_case>
<#assign entityName = model.entityName>

package ${model.package};

import com.datacoper.cooperate.arquitetura.common.services.DetailCrudService;
import com.${company}.cooperate.${module}.common.entities.${model.entityNameMaster};
import com.${company}.cooperate.${module}.common.entities.${model.entityName};

public interface ${className} extends DetailCrudService<${entityName}, ${model.entityNameMaster}> {

    

}
