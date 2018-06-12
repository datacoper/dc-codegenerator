<#assign className = model.className>
<#assign company = model.company.packageName>
<#assign module = model.moduleName?lower_case>
<#assign entityName = model.entityName>

package ${model.package};

import javax.annotation.ManagedBean;
import javax.transaction.Transactional;

import com.datacoper.arquiteturarest.resource.DetailCRUDResource;
import com.${company}.cooperate.${module}.common.entities.${entityName};
import com.${company}.cooperate.${module}.common.entities.${model.entityNameMaster};
import com.${company}.cooperate.${module}.common.services.${entityName}Service;
import com.${company}.cooperate.${module}.rest.common.dto.${entityName}DTO;
import com.${company}.cooperate.${module}.rest.common.resources.${entityName}Resource;
import com.${company}.cooperate.${module}.server.eao.${entityName}EAO;

@Transactional
@ManagedBean
public class ${className} extends DetailCRUDResource<${entityName}, ${model.entityNameMaster}, ${entityName}DTO, ${entityName}EAO, ${entityName}Service> implements ${entityName}Resource {
    
}
