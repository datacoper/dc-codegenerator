<#assign className = class.className>
<#assign company = class.company.packag>
<#assign module = class.moduleBasic?lower_case>
package ${class.package};

import com.${company}.cooperate.${module}.common.entities.${class.classNameBasic};
import com.${company}.cooperate.${module}.common.consultas.${class.classNameBasic}VO;
import com.${company}.cooperate.${module}.server.eao.${class.classNameBasic}EAO;
import com.${company}.cooperate.${module}.server.consultas.Query${class.classNameBasic};
import com.datacoper.arquitetura.server.persistence.impl.GenericEAOImpl;
import com.datacoper.cooperate.arquitetura.common.beans.PageResult;
import com.datacoper.cooperate.arquitetura.common.beans.BeanConsultaGroup;
<#list class.imports as import>
import ${import};
</#list>

public class ${className} extends GenericEAOImpl<${class.classNameBasic}> implements ${class.classNameBasic}EAO {
    
    <#include "defaultConstructor.ftl">

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
    }

}
