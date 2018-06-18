<#assign className = model.className>
<#assign variableName = model.className?uncap_first>
<#assign company = model.company.packageName>
<#assign module = model.modulePackageName>

package ${model.package};

import java.util.HashSet;
import java.util.Set;

import com.${company}.cooperate.arquitetura.common.services.DetailCrudService;
import com.${company}.cooperate.${module}.common.services.${model.entityName}Service;
<#list model.details as detail>
import com.${company}.cooperate.${module}.common.services.${detail.entityName}Service;
</#list>
import ${model.entityType};
import com.datacoper.cooperate.nucleo.server.service.MasterCrudServiceImpl;

public class ${className} extends MasterCrudServiceImpl<${model.entityName}> implements ${model.entityName}Service{

	public ${className}() {
		super(${model.entityName}.class, new Validador${model.entityName}(), new String[] {
				<#list model.attributes as attribute>
                	"${attribute.name?uncap_first}",
        		</#list>
		});
		
	}

	@Override
	public Set<Class<? extends DetailCrudService<?, ${model.entityName}>>> getDetailsServices() {
		Set<Class<? extends DetailCrudService<?, ${model.entityName}>>> detailServices = new HashSet<>();		
		<#list model.details as detail>
       	detailServices.add(${detail.entityName}Service.class);
		</#list>
		return detailServices;
	}
	
}
