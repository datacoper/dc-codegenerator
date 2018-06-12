<#assign className = model.className>
<#assign company = model.company.packag>
<#assign module = model.moduleBasic>
package ${model.package};

import javax.ejb.Remote;

import java.util.List;

import com.datacoper.cooperate.arquitetura.common.beans.BeanConsultaGroup;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.datacoper.cooperate.arquitetura.common.interfaces.IRemote;
import com.${company}.cooperate.${module?lower_case}.common.entities.${model.classNameBasic};
import com.${company}.cooperate.${module?lower_case}.common.consultas.${model.classNameBasic}VO;
<#list model.imports as import>
import ${import};
</#list>

@Remote
public interface ${className} extends IRemote {
    
    public ${model.classNameBasic} find(Long id);

    public ${model.classNameBasic} findFetch(Long id);

    public PageResult<${model.classNameBasic}VO> find(BeanConsultaGroup consultaGroup);

    public List<${model.classNameBasic}> find(List<Long> ids);

    public Long confirm(${model.classNameBasic} ${model.classNameBasic?uncap_first});

    public void excluir(Long id);
}
