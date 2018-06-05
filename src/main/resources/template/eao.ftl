<#assign className = class.className>
<#assign company = class.company.packageName>
<#assign module = class.moduleName?lower_case>
package ${class.package};

import com.${company}.cooperate.arquitetura.common.beans.BeanConsultaGroup;
import com.${company}.cooperate.arquitetura.common.beans.PageResult;
import com.${company}.cooperate.${module}.common.entities.${class.entityName};
import com.${company}.cooperate.${module}.common.consultas.${class.entityName}VO;
import com.datacoper.arquitetura.server.persistence.GenericEAO;

public interface ${className} extends GenericEAO<${class.entityName}> {

    public PageResult<${class.entityName}VO> find(BeanConsultaGroup consultaGroup);
}