<#assign className = class.className>
<<<<<<< HEAD
<#assign company = class.company.packageName>
<#assign module = class.moduleName?lower_case>
<#assign eao = module + "EAO.get" + class.entityName + "EAO()">
<#assign gerenciador = "gerenciador" + class.entityName>
=======
<#assign company = class.company.packag>
<#assign module = class.moduleBasic>
<#assign gerenciador = "gerenciador" + class.classNameBasic>
<#assign eao = class.classNameBasic?uncap_first + "EAO">
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
package ${class.package};

import java.util.List;

import javax.ejb.Stateless;

<<<<<<< HEAD
import com.${company}.cooperate.${module}.server.eao.${module?cap_first}EAO;
import com.${company}.cooperate.${module}.common.remote.${class.entityName}Remote;
import com.${company}.cooperate.${module}.common.entities.${class.entityName};
import com.${company}.cooperate.${module}.common.consultas.${class.entityName}VO;
=======
import com.${company}.cooperate.${module?lower_case}.server.eao.${module?cap_first}EAO;
import com.${company}.cooperate.${module?lower_case}.common.remote.${class.classNameBasic}Remote;
import com.${company}.cooperate.${module?lower_case}.common.entities.${class.classNameBasic};
import com.${company}.cooperate.${module?lower_case}.common.consultas.${class.classNameBasic}VO;
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
import com.datacoper.cooperate.arquitetura.common.beans.BeanConsultaGroup;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.datacoper.cooperate.arquitetura.common.exception.DCLogicException;
import com.datacoper.cooperate.arquitetura.common.exception.DCRuntimeException;
import com.datacoper.cooperate.arquitetura.common.persistence.entities.EntityState;

@Stateless
public class ${className} implements ${class.entityName}Remote {

    private ${module}EAO ${module?uncap_first}EAO = new ${module}EAO();

    private ${class.classNameBasic}EAO ${eao} = ${module?uncap_first}EAO.get${class.classNameBasic}EAO();
    
    private Gerenciador${class.entityName} gerenciador = new Gerenciador${class.entityName}();
    
    <#include "defaultConstructor.ftl">    

    @Override
<<<<<<< HEAD
    public Optional<${class.entityName}> find(Long id) {
        return ${eao}.findOptional(id);
    }

    @Override
    public Optional<${class.entityName}> findFetch(Long id) {
=======
    public ${class.classNameBasic} find(Long id) {
        return ${eao}.find(id);
    }

    @Override
    public ${class.classNameBasic} findFetch(Long id) {
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
        return ${eao}.findFetch(id);
    }

    @Override
    public PageResult<${class.entityName}VO> find(BeanConsultaGroup consultaGroup) {
        return ${eao}.find(consultaGroup);
    }

    @Override
<<<<<<< HEAD
    public List<${class.entityName}> find(List<Long> ids) {
        return ${eao}.find(ids);
=======
    public List<${class.classNameBasic}> find(List<Long> ids) {
        // Transforma para array e chama o método que busca por IDs
        return ${eao}.find(ids.toArray(new Long[]{}));
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
    }

    @Override
    public Long confirm(${class.entityName} ${class.entityName?uncap_first}) {
        try {
            return gerenciador.confirm(${class.entityName?uncap_first}).getId();
        } catch (DCLogicException e) {
            throw new DCRuntimeException(e);
        }
    }

    @Override
    public void excluir(Long id) {
        ${class.entityName} ${class.entityName?uncap_first} = ${eao}.find(id);
        ${class.entityName?uncap_first}.setEntityState(EntityState.DELETED);

        confirm(${class.entityName?uncap_first});
    }
}