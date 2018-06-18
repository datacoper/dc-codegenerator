<#assign className = model.className>
<#assign company = model.company.packageName>
<#assign module = model.modulePackageName>
package ${model.package};

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.${company}.cooperate.${module}.common.consultas.${model.entityName}VO;
import com.${company}.cooperate.${module}.rest.common.dto.${model.entityName}DTO;
import com.datacoper.arquiteturarest.interfaces.ICRUDResource;

@Path(${className}.PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ${className} extends ICRUDResource<${model.entityName}VO, ${model.entityName}DTO> {
    
    public static final String PATH = "/${model.entityName?lower_case}"; 
    
}