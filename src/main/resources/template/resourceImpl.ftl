<#assign className = class.className>
<#assign variableName = class.className?uncap_first>
<#assign company = class.company.packageName>
<#assign module = class.moduleBasic?lower_case>
package ${class.package};

import javax.annotation.ManagedBean;
import javax.transaction.Transactional;

import com.datacoper.arquiteturarest.resource.MasterCRUDResource;
import com.datacoper.arquiteturarest.resource.SeletorParams;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.datacoper.cooperate.faturamento.common.consultas.${class.entityName}VO;
import com.datacoper.cooperate.faturamento.common.entities.${class.entityName};
import com.datacoper.cooperate.faturamento.rest.common.dto.${class.entityName}DTO;
import com.datacoper.cooperate.faturamento.rest.common.resources.${class.entityName}Resource;
import com.datacoper.cooperate.faturamento.server.eao.${class.entityName}EAO;
<#list class.imports as import>
import ${import};
</#list>

@Transactional
@ManagedBean
public class ${class.entityName}ResourceImpl extends MasterCRUDResource<${class.entityName}, ${class.entityName}DTO, ${class.entityName}VO, ${class.entityName}EAO, ${class.entityName}Service> implements ${class.entityName}Resource {

	@Override
	protected PageResult<${class.entityName}VO> consultar(SeletorParams seletorParams) {
		return getEAO().find(seletorParams.getBeanConsultaGroup());
	}

    
}
