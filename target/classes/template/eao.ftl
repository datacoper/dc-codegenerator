<#assign className = class.className>
<#assign company = class.company.packag>
<#assign module = class.moduleBasic?lower_case>
package ${class.package};

import java.util.Optional;
import com.datacoper.cooperate.arquitetura.common.beans.BeanConsultaGroup;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.${company}.cooperate.${module}.common.entities.${class.classNameBasic};
import com.${company}.cooperate.${module}.common.consultas.${class.classNameBasic}VO;
import com.datacoper.arquitetura.server.persistence.GenericEAO;
<#list class.imports as import>
import ${import};
</#list>

public interface ${className} extends GenericEAO<${class.classNameBasic}> {

    public Long getNextCode();

    public Optional<${class.classNameBasic}> findFetch(Long id);

    public PageResult<${class.classNameBasic}VO> find(BeanConsultaGroup consultaGroup);
}