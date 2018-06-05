<#assign className = class.className>
<#assign company = class.company.packageName>
<#assign module = class.moduleName?lower_case>
package ${class.package};

<<<<<<< HEAD
import java.util.Optional;
import com.${company}.cooperate.${module}.common.entities.${class.entityName};
import com.${company}.cooperate.${module}.common.consultas.${class.entityName}VO;
import com.${company}.cooperate.${module}.server.eao.${class.entityName}EAO;
import com.${company}.cooperate.${module}.server.consultas.Query${class.entityName};
=======
import com.${company}.cooperate.${module}.common.entities.${class.classNameBasic};
import com.${company}.cooperate.${module}.common.consultas.${class.classNameBasic}VO;
import com.${company}.cooperate.${module}.server.eao.${class.classNameBasic}EAO;
import com.${company}.cooperate.${module}.server.consultas.Query${class.classNameBasic};
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
import com.datacoper.arquitetura.server.persistence.impl.GenericEAOImpl;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.datacoper.cooperate.arquitetura.common.beans.BeanConsultaGroup;

public class ${className} extends GenericEAOImpl<${class.entityName}> implements ${class.entityName}EAO {
    
    <#include "defaultConstructor.ftl">

<<<<<<< HEAD
    public PageResult<${class.entityName}VO> find(BeanConsultaGroup consultaGroup) {
        return getPagedBeanList(new Query${class.entityName}(), consultaGroup);
=======
    public Long getNextCode() {
        return super.getNextVal("${class.classNameBasic?upper_case}_CODIGO");
    }
    
    public ${class.classNameBasic} findFetch(Long id) {
        <#assign alias = class.classNameBasic?substring(0, 1)?lower_case>
        return createDCTypedQuery()
                .append("select ${alias} ")
                .append("  from ${class.classNameBasic} ${alias} ")
                .appendAndSetParameter(" where ${alias}.id${class.classNameBasic} = :id${class.classNameBasic}", id)
                .getSingleResultOrThrowNoResultException();
    }

    public PageResult<${class.classNameBasic}VO> find(BeanConsultaGroup consultaGroup) {
        return getPagedBeanList(new Query${class.classNameBasic}(), consultaGroup);
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
    }

}
