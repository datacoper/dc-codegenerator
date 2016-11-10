<#assign className = class.className>
<#assign company = class.company.packag>
<#assign module = class.moduleBasic?lower_case>
<#assign eao = module + "EAO.get" + class.classNameBasic + "EAO()">
<#assign gerenciador = "gerenciador" + class.classNameBasic>
package ${class.package};

import java.util.Optional;
import java.util.List;

import javax.ejb.Stateless;

import com.${company}.cooperate.${module}.server.eao.${module?cap_first}EAO;
import com.${company}.cooperate.${module}.common.remote.${class.classNameBasic}Remote;
import com.${company}.cooperate.${module}.common.entities.${class.classNameBasic};
import com.${company}.cooperate.${module}.common.consultas.${class.classNameBasic}VO;
import com.datacoper.cooperate.arquitetura.common.beans.BeanConsultaGroup;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.datacoper.cooperate.arquitetura.common.exception.DCLogicException;
import com.datacoper.cooperate.arquitetura.common.exception.DCRuntimeException;
import com.datacoper.cooperate.arquitetura.common.persistence.entities.EntityState;
<#list class.imports as import>
import ${import};
</#list>

@Stateless
public class ${className} implements ${class.classNameBasic}Remote {

    private ${module?cap_first}EAO ${module}EAO = new ${module?cap_first}EAO();
    
    private Gerenciador${class.classNameBasic} gerenciador = new Gerenciador${class.classNameBasic}();
    
    <#include "defaultConstructor.ftl">    

    @Override
    public Optional<${class.classNameBasic}> find(Long id) {
        return ${eao}.findOptional(id);
    }

    @Override
    public Optional<${class.classNameBasic}> findFetch(Long id) {
        return ${eao}.findFetch(id);
    }

    @Override
    public PageResult<${class.classNameBasic}VO> find(BeanConsultaGroup consultaGroup) {
        return ${eao}.find(consultaGroup);
    }

    @Override
    public List<${class.classNameBasic}> find(List<Long> ids) {
        return ${eao}.find(ids);
    }

    @Override
    public Long confirm(${class.classNameBasic} ${class.classNameBasic?uncap_first}) {
        try {
            return gerenciador.confirm(${class.classNameBasic?uncap_first}).getId();
        } catch (DCLogicException e) {
            throw new DCRuntimeException(e);
        }
    }

    @Override
    public void excluir(Long id) {
        ${class.classNameBasic} ${class.classNameBasic?uncap_first} = ${eao}.find(id);
        ${class.classNameBasic?uncap_first}.setEntityState(EntityState.DELETED);

        confirm(${class.classNameBasic?uncap_first});
    }
}