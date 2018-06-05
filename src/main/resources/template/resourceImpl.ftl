<#assign className = class.className>
<#assign variableName = class.className?uncap_first>
<<<<<<< HEAD
<#assign company = class.company.packageName>
<#assign module = class.moduleName?lower_case>
package ${class.package};

import javax.annotation.ManagedBean;
import javax.transaction.Transactional;

import com.datacoper.arquiteturarest.resource.MasterCRUDResource;
import com.datacoper.arquiteturarest.resource.SeletorParams;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.${company}.cooperate.${module}.common.consultas.${class.entityName}VO;
import com.${company}.cooperate.${module}.common.entities.${class.entityName};
import com.${company}.cooperate.${module}.common.services.${class.entityName}Service;
import com.${company}.cooperate.${module}.rest.common.dto.${class.entityName}DTO;
import com.${company}.cooperate.${module}.rest.common.resources.${class.entityName}Resource;
import com.${company}.cooperate.${module}.server.eao.${class.entityName}EAO;

@Transactional
@ManagedBean
public class ${class.entityName}ResourceImpl extends MasterCRUDResource<${class.entityName}, ${class.entityName}DTO, ${class.entityName}VO, ${class.entityName}EAO, ${class.entityName}Service> implements ${class.entityName}Resource {

	@Override
	protected PageResult<${class.entityName}VO> consultar(SeletorParams seletorParams) {
		return getEAO().find(seletorParams.getBeanConsultaGroup());
	}

    
=======
<#assign company = class.company.packag>
<#assign module = class.moduleBasic>
package ${class.package};

import java.util.List;

import com.datacoper.arquitetura.common.lookup.ILookup;
import com.datacoper.arquiteturarest.cooperate.AbstractResourceContexto;
import com.datacoper.arquiteturarest.dto.DTOConverter;
import com.datacoper.arquiteturarest.resposta.RespostaId;
import com.${company}.cooperate.${module?lower_case}.rest.common.resources.${class.classNameBasic}Resource;
import com.${company}.cooperate.${module?lower_case}.common.consultas.${class.classNameBasic}VO;
import com.${company}.cooperate.${module?lower_case}.common.entities.${class.classNameBasic};
import com.${company}.cooperate.${module?lower_case}.common.remote.${class.classNameBasic}Remote;
import com.${company}.cooperate.${module?lower_case}.rest.common.dto.${class.classNameBasic}DTO;
import com.${company}.cooperate.${module?lower_case}.common.remote.Enum${module?cap_first}<#if company != "datacoper">${company?cap_first}</#if>Remote;
import com.datacoper.cooperate.arquitetura.common.beans.BeanConsultaGroup;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.datacoper.cooperate.arquitetura.common.persistence.entities.EntityState;
<#list class.imports as import>
import ${import};
</#list>

public class ${className} extends AbstractResourceContexto<${class.classNameBasic}Remote> implements ${class.classNameBasic}Resource {

    <#include "defaultConstructor.ftl">

    private DTOConverter<${class.classNameBasic}, ${class.classNameBasic}DTO> getDTOConverter() {
        return DTOConverter.createInstance(${class.classNameBasic}.class, ${class.classNameBasic}DTO.class); 
    }

    @Override
    public ILookup getLookup() {
        return Enum${module?cap_first}<#if company != "datacoper">${company?cap_first}</#if>Remote.${class.classNameBasic?upper_case};
    }

    @Override
    public void excluir(Long id) {
        doLookup().excluir(id);
    }

    @Override
    public PageResult<${class.classNameBasic}VO> consultar(String query, String params) {
        BeanConsultaGroup beanConsulta = newBeanConsultaGroup(query);

        return doLookup().find(beanConsulta);
    }

    @Override
    public ${class.classNameBasic}DTO buscarPorId(Long id) {
        ${class.classNameBasic} ${class.classNameBasic?uncap_first} = doLookup().find(id);

        return getDTOConverter().converterEntityParaDTO(${class.classNameBasic?uncap_first});
    }

    @Override
    public List<${class.classNameBasic}DTO> listarPorId(List<Long> ids) {
        List<${class.classNameBasic}> ${class.classNameBasic?uncap_first}s = doLookup().find(ids);

        return getDTOConverter().converterEntityParaDTO(${class.classNameBasic?uncap_first}s);
    }

    @Override
    public RespostaId inserir(${class.classNameBasic}DTO ${class.classNameBasic?uncap_first}DTO) {
        ${class.classNameBasic} ${class.classNameBasic?uncap_first} = getDTOConverter().converterDTOParaEntity(${class.classNameBasic?uncap_first}DTO, EntityState.NEW);

        Long id = confirm(${class.classNameBasic?uncap_first});

        return new RespostaId(id);
    }

    @Override
    public void atualizar(Long id, ${class.classNameBasic}DTO ${class.classNameBasic?uncap_first}DTO) {
        ${class.classNameBasic} ${class.classNameBasic?uncap_first} = getDTOConverter().converterDTOParaEntity(${class.classNameBasic?uncap_first}DTO, EntityState.MODIFIED);

        confirm(${class.classNameBasic?uncap_first});
    }

    private Long confirm(${class.classNameBasic} ${class.classNameBasic?uncap_first}) {
        return doLookup().confirm(${class.classNameBasic?uncap_first});
    }
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
}
