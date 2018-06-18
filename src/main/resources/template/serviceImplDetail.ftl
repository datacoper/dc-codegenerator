<#assign className = model.className>
<#assign variableName = model.className?uncap_first>
<#assign company = model.company.packageName>
<#assign module = model.modulePackageName>
<#assign entityName = model.entityName>

package ${model.package};

import java.util.Collection;
import java.util.List;

import ${model.entityPackage}.${model.entityNameMaster};
import ${model.entityPackage}.${entityName};
import com.${company}.cooperate.${module}.common.services.${entityName}Service;
import com.datacoper.cooperate.nucleo.server.service.DetailCrudServiceImpl;

public class ${className} extends DetailCrudServiceImpl<${entityName}, ${model.entityNameMaster}> implements ${entityName}Service {

    public ${className}() {
        super(${entityName}.class, new Validador${entityName}(), new String[] {
				<#list model.attributes as attribute>
                	"${attribute.name?uncap_first}",
        		</#list>
		});
    }
    
    @Override
    public void setParent(${model.entityNameMaster} master, ${entityName} detail) {
        detail.set${model.entityNameMaster}(master);
    }

    @Override
    public Collection<${entityName}> getDetails(${model.entityNameMaster} master) {
        return master.get${entityName}s();
    }
}
