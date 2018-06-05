<#assign className = class.className>
<#assign company = class.company.packageName>
<#assign module = class.moduleName?lower_case>
package ${class.package};

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

<<<<<<< HEAD
import com.${company}.cooperate.${module}.common.consultas.${class.entityName}VO;
import com.${company}.cooperate.${module}.rest.common.dto.${class.entityName}DTO;
=======
import com.${company}.cooperate.${module}.rest.common.constants.ConstantsResourcePath;
import com.${company}.cooperate.${module}.rest.common.dto.${class.classNameBasic}DTO;
import com.${company}.cooperate.${module}.common.consultas.${class.classNameBasic}VO;
import com.datacoper.arquiteturarest.resposta.RespostaId;
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
import com.datacoper.arquiteturarest.interfaces.ICRUDResource;

<<<<<<< HEAD
@Path(${className}.PATH)
=======
@Path(ConstantsResourcePath.RESOURCE_${class.classNameBasic?upper_case})
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ${className} extends ICRUDResource<${class.entityName}VO, ${class.entityName}DTO> {
    
    public static final String PATH = "${class.entityName?lower_case}"; 
    
}