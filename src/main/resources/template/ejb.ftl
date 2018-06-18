<#assign className = model.className>
<#assign company = model.company.packageName>
<#assign module = model.modulePackageName>
<#assign eao = module + "EAO.get" + model.entityName + "EAO()">
<#assign gerenciador = "gerenciador" + model.entityName>
package ${model.package};

import java.util.Optional;
import java.util.List;

import javax.ejb.Stateless;

import com.${company}.cooperate.${module}.server.eao.${module?cap_first}EAO;
import com.${company}.cooperate.${module}.common.remote.${model.entityName}Remote;
import com.${company}.cooperate.${module}.common.entities.${model.entityName};
import com.${company}.cooperate.${module}.common.consultas.${model.entityName}VO;
import com.datacoper.cooperate.arquitetura.common.beans.BeanConsultaGroup;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.datacoper.cooperate.arquitetura.common.exception.DCLogicException;
import com.datacoper.cooperate.arquitetura.common.exception.DCRuntimeException;
import com.datacoper.cooperate.arquitetura.common.persistence.entities.EntityState;
<#list model.imports as import>
import ${import};
</#list>

@Stateless
public class ${className} implements ${model.entityName}Remote {

    private ${module?cap_first}EAO ${module}EAO = new ${module?cap_first}EAO();
    
    private Gerenciador${model.entityName} gerenciador = new Gerenciador${model.entityName}();
    
    <#include "defaultConstructor.ftl">    

    @Override
    public Optional<${model.entityName}> find(Long id) {
        return ${eao}.findOptional(id);
    }

    @Override
    public Optional<${model.entityName}> findFetch(Long id) {
        return ${eao}.findFetch(id);
    }

    @Override
    public PageResult<${model.entityName}VO> find(BeanConsultaGroup consultaGroup) {
        return ${eao}.find(consultaGroup);
    }

    @Override
    public List<${model.entityName}> find(List<Long> ids) {
        return ${eao}.find(ids);
    }

    @Override
    public Long confirm(${model.entityName} ${model.entityName?uncap_first}) {
        try {
            return gerenciador.confirm(${model.entityName?uncap_first}).getId();
        } catch (DCLogicException e) {
            throw new DCRuntimeException(e);
        }
    }

    @Override
    public void excluir(Long id) {
        ${model.entityName} ${model.entityName?uncap_first} = ${eao}.find(id);
        ${model.entityName?uncap_first}.setEntityState(EntityState.DELETED);

        confirm(${model.entityName?uncap_first});
    }
}