<#assign className = class.className>
<#assign company = class.company.packag>
<#assign module = class.moduleBasic?lower_case>
package ${class.package};

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.${company}.cooperate.${module}.rest.common.constants.Constants${class.moduleBasic}ResourcePath;
import com.${company}.cooperate.${module}.rest.common.dto.${class.classNameBasic}DTO;
import com.${company}.cooperate.${module}.common.consultas.${class.classNameBasic}VO;
import com.datacoper.arquiteturarest.resposta.RespostaId;
import com.datacoper.arquiteturarest.interfaces.ICRUDResource;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
<#list class.imports as import>
import ${import};
</#list>

@Path(Constants${class.moduleBasic}ResourcePath.RESOURCE_${class.classNameBasic?upper_case})
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ${className} extends ICRUDResource<${class.classNameBasic}VO, ${class.classNameBasic}DTO> {
    @GET
    @Path("/find")
    PageResult<${class.classNameBasic}VO> consultar(@QueryParam("query") String query, @QueryParam("params") String params);

    @GET
    @Path("/{id}")
    ${class.classNameBasic}DTO buscarPorId(@PathParam("id") Long id);

    @GET
    @Path("/findbyids")
    List<${class.classNameBasic}DTO> listarPorId(@QueryParam("ids") List<Long> ids);
	
    @POST
    RespostaId inserir(${class.classNameBasic}DTO dto);

    @PUT
    @Path("/{id}")
    void atualizar(@PathParam("id") Long id, ${class.classNameBasic}DTO dto);
	
    @DELETE
    @Path("/{id}")
    void excluir(@PathParam("id") Long id);
}