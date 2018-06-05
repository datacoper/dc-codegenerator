<#assign className = class.className>
<<<<<<< HEAD
<#assign company = class.company.packageName>
<#assign module = class.moduleName?lower_case>
package ${class.package};

import com.${company}.cooperate.arquitetura.common.beans.BeanConsultaGroup;
import com.${company}.cooperate.arquitetura.common.beans.PageResult;
import com.${company}.cooperate.${module}.common.entities.${class.entityName};
import com.${company}.cooperate.${module}.common.consultas.${class.entityName}VO;
=======
<#assign company = class.company.packag>
<#assign module = class.moduleBasic>
package ${class.package};

import com.datacoper.cooperate.arquitetura.common.beans.BeanConsultaGroup;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.${company}.cooperate.${module?lower_case}.common.entities.${class.classNameBasic};
import com.${company}.cooperate.${module?lower_case}.common.consultas.${class.classNameBasic}VO;
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
import com.datacoper.arquitetura.server.persistence.GenericEAO;

public interface ${className} extends GenericEAO<${class.entityName}> {

<<<<<<< HEAD
    public PageResult<${class.entityName}VO> find(BeanConsultaGroup consultaGroup);
=======
    public Long getNextCode();

    public ${class.classNameBasic} findFetch(Long id);

    public PageResult<${class.classNameBasic}VO> find(BeanConsultaGroup consultaGroup);
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
}