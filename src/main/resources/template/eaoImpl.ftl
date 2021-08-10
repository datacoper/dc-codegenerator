<#assign className = model.className>
<#assign company = model.company.packageName>
<#assign module = model.modulePackageName>
package ${model.package};

import com.${company}.cooperate.${module}.common.entities.${model.entityName};
import com.${company}.cooperate.${module}.server.eao.${model.entityName}EAO;
<#if model.master>
import com.${company}.cooperate.${module}.common.consultas.${model.entityName}VO;
import com.${company}.cooperate.${module}.server.consultas.Query${model.entityName};
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.datacoper.cooperate.arquitetura.common.beans.BeanConsultaGroup;
</#if>
import com.datacoper.arquitetura.server.persistence.impl.GenericEAOImpl;

public class ${className} extends GenericEAOImpl<${model.entityName}> implements ${model.entityName}EAO {
    
    <#if model.master>
    @Override
    public PageResult<${model.entityName}VO> find(BeanConsultaGroup consultaGroup) {
        return getPagedBeanList(new Query${model.entityName}(), consultaGroup);
    }
    </#if>

}
