<#assign className = class.className>
<#assign company = class.company.packag>
<#assign module = class.moduleBasic>
<#assign gerenciador = "gerenciador" + class.classNameBasic>
<#assign eao=${class.classNameBasic?uncap_first} + "EAO">
package ${class.package};

import java.util.List;

import javax.ejb.Stateless;

import com.${company}.cooperate.${module?lower_case}.server.eao.${module?cap_first}EAO;
import com.${company}.cooperate.${module?lower_case}.common.remote.${class.classNameBasic}Remote;
import com.${company}.cooperate.${module?lower_case}.common.entities.${class.classNameBasic};
import com.${company}.cooperate.${module?lower_case}.common.consultas.${class.classNameBasic}VO;
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

    private ${module}EAO ${module?uncap_first}EAO = new ${module}EAO();

    private ${class.classNameBasic}EAO ${eao} = ${module?uncap_first}EAO.get${class.classNameBasic}EAO();
    
    private Gerenciador${class.classNameBasic} gerenciador = new Gerenciador${class.classNameBasic}();
    
    <#include "defaultConstructor.ftl">    

    @Override
    public ${class.classNameBasic} find(Long id) {
        return ${eao}.find(id);
    }

    @Override
    public ${class.classNameBasic} findFetch(Long id) {
        return ${eao}.findFetch(id);
    }

    @Override
    public PageResult<${class.classNameBasic}VO> find(BeanConsultaGroup consultaGroup) {
        return ${eao}.find(consultaGroup);
    }

    @Override
    public List<${class.classNameBasic}> find(List<Long> ids) {
        // Transforma para array e chama o método que busca por IDs
        return ${eao}.find(ids.toArray(new Long[]{}));
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