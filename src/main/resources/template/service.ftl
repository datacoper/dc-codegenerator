<#assign className = class.className>
<#assign company = class.company.packageName>
<#assign module = class.moduleBasic?lower_case>
package ${class.package};

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.${company}.cooperate.${module}.common.consultas.${class.entityName}VO;
import com.${company}.cooperate.${module}.rest.common.dto.${class.entityName}DTO;
import com.datacoper.arquiteturarest.interfaces.ICRUDResource;
<#list class.imports as import>
import ${import};
</#list>

@Path(${className}.PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ${className} extends ICRUDResource<${class.entityName}VO, ${class.entityName}DTO> {
    
    public static final String PATH = "${class.entityName?lower_case}"; 
    
}