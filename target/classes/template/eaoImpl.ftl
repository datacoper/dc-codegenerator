<#assign className = class.className>
<#assign company = class.company.packageName>
<#assign module = class.moduleName?lower_case>
package ${class.package};

import java.util.Optional;
import com.${company}.cooperate.${module}.common.entities.${class.entityName};
import com.${company}.cooperate.${module}.common.consultas.${class.entityName}VO;
import com.${company}.cooperate.${module}.server.eao.${class.entityName}EAO;
import com.${company}.cooperate.${module}.server.consultas.Query${class.entityName};
import com.datacoper.arquitetura.server.persistence.impl.GenericEAOImpl;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.datacoper.cooperate.arquitetura.common.beans.BeanConsultaGroup;

public class ${className} extends GenericEAOImpl<${class.entityName}> implements ${class.entityName}EAO {
    
    <#include "defaultConstructor.ftl">

    public PageResult<${class.entityName}VO> find(BeanConsultaGroup consultaGroup) {
        return getPagedBeanList(new Query${class.entityName}(), consultaGroup);
    }

}
