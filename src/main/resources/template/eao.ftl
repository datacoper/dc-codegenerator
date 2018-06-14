<#assign className = model.className>
<#assign company = model.company.packageName>
<#assign module = model.moduleName?lower_case>
package ${model.package};

<#if model.master>
import com.${company}.cooperate.arquitetura.common.beans.BeanConsultaGroup;
import com.${company}.cooperate.arquitetura.common.beans.PageResult;
import com.${company}.cooperate.${module}.common.consultas.${model.entityName}VO;
</#if>
import com.datacoper.arquitetura.server.persistence.GenericEAO;
import com.${company}.cooperate.${module}.common.entities.${model.entityName};

public interface ${className} extends GenericEAO<${model.entityName}> {
	
	<#if model.master>
    public PageResult<${model.entityName}VO> find(BeanConsultaGroup consultaGroup);
    </#if>
}