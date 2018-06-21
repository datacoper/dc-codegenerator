<#assign className = model.className>
<#assign company = model.company.packageName>
<#assign module = model.modulePackageName>
<#assign entityName = model.entityName>
package ${model.package};

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.${company}.cooperate.${module}.rest.common.dto.${entityName}DTO;
import com.datacoper.arquiteturarest.interfaces.IDetailCRUDResource;

@Path(${className}.PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ${className} extends IDetailCRUDResource<${entityName}DTO> {
    
    public static final String PATH = TesteResource.PATH+"/{"+PARENT_ID+"}/${entityName?lower_case}"; 
    
}