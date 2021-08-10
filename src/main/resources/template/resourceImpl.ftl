<#assign className = model.className>
<#assign variableName = model.className?uncap_first>
<#assign company = model.company.packageName>
<#assign module = model.modulePackageName>
package ${model.package};

import javax.annotation.ManagedBean;
import javax.transaction.Transactional;

import com.datacoper.arquiteturarest.resource.MasterCRUDResource;
import com.datacoper.arquiteturarest.resource.SeletorParams;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.${company}.cooperate.${module}.common.consultas.${model.entityName}VO;
import com.${company}.cooperate.${module}.common.entities.${model.entityName};
import com.${company}.cooperate.${module}.common.services.${model.entityName}Service;
import com.${company}.cooperate.${module}.rest.common.dto.${model.entityName}DTO;
import com.${company}.cooperate.${module}.rest.common.resources.${model.entityName}Resource;
import com.${company}.cooperate.${module}.server.eao.${model.entityName}EAO;

@Transactional
@ManagedBean
public class ${className} extends MasterCRUDResource<${model.entityName}, ${model.entityName}DTO, ${model.entityName}VO, ${model.entityName}EAO, ${model.entityName}Service> implements ${model.entityName}Resource {

	@Override
	protected PageResult<${model.entityName}VO> consultar(SeletorParams seletorParams) {
		return getEAO().find(seletorParams.getBeanConsultaGroup());
	}
    
}
