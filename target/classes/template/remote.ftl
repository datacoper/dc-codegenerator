<#assign className = class.className>
<#assign company = class.company.packageName>
<#assign module = class.moduleBasic?lower_case>
package ${class.package};

import javax.ejb.Remote;

import java.util.Optional;
import java.util.List;

import com.datacoper.cooperate.arquitetura.common.beans.BeanConsultaGroup;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.datacoper.cooperate.arquitetura.common.interfaces.IRemote;
import com.${company}.cooperate.${module}.common.entities.${class.entityName};
import com.${company}.cooperate.${module}.common.consultas.${class.entityName}VO;
<#list class.imports as import>
import ${import};
</#list>

@Remote
public interface ${className} extends IRemote {
    
    public Optional<${class.entityName}> find(Long id);

    public Optional<${class.entityName}> findFetch(Long id);

    public PageResult<${class.entityName}VO> find(BeanConsultaGroup consultaGroup);

    public List<${class.entityName}> find(List<Long> ids);

    public Long confirm(${class.entityName} ${class.entityName?uncap_first});

    public void excluir(Long id);
}
