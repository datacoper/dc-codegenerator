<#assign className = class.className>
<#assign company = class.company.packageName>
<#assign module = class.moduleBasic?lower_case>
package ${class.package};

import com.datacoper.cooperate.arquitetura.common.beans.BeanConsultaGroup;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.${company}.cooperate.${module}.common.entities.${class.entityName};
import com.${company}.cooperate.${module}.common.consultas.${class.entityName}VO;
import com.datacoper.arquitetura.server.persistence.GenericEAO;
<#list class.imports as import>
import ${import};
</#list>

public interface ${className} extends GenericEAO<${class.entityName}> {

    public PageResult<${class.entityName}VO> find(BeanConsultaGroup consultaGroup);
}