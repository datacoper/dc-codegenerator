<#assign className = model.className>
<#assign company = model.company.packageName>
<#assign module = model.modulePackageName>
<#assign entityName = model.entityName>

package ${model.package};

import com.datacoper.cooperate.arquitetura.common.services.DetailCrudService;
import com.${model.entityPackage}.${model.entityNameMaster};
import com.${model.entityPackage}.${model.entityName};

public interface ${className} extends DetailCrudService<${entityName}, ${model.entityNameMaster}> {

    

}
