<#assign className = class.className>
<#assign variableName = class.className?uncap_first>
<#assign company = class.company.packageName>
<#assign module = class.moduleName?lower_case>
package ${class.package};

import java.util.Collections;
import java.util.Set;

import com.${company}.cooperate.arquitetura.common.services.DetailCrudService;
import com.${company}.cooperate.${module}.common.services.${class.entityName}Service;
import com.${company}.cooperate.${module}.common.entities.${class.entityName};
import com.datacoper.cooperate.nucleo.server.service.MasterCrudServiceImpl;

public class ${class.entityName}ServiceImpl extends MasterCrudServiceImpl<${class.entityName}> implements ${class.entityName}Service{

	public ${class.entityName}ServiceImpl() {
		super(${class.entityName}.class, new Validador${class.entityName}(), new String[] {
				<#list class.attributes as attribute>
                	"${class.entityName?uncap_first}"                        
        		</#list>
		});
		
	}

	@Override
	public Set<Class<? extends DetailCrudService<?, ${class.entityName}>>> getDetailsServices() {
		//TODO add aqui os services details
		return Collections.emptySet();
	}
	
}
