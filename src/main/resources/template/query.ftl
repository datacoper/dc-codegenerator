<#assign className = class.className>
<<<<<<< HEAD
<#assign company = class.company.packageName>
<#assign module = class.moduleName?lower_case>
=======
<#assign company = class.company.packag>
<#assign module = class.moduleBasic?lower_case>
<#assign attributes = class.attributes>
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
package ${class.package};

import com.datacoper.arquitetura.server.consultas.AbstractConsulta;
import com.${company}.cooperate.${module}.common.consultas.${class.entityName}VO;
import com.${company}.cooperate.${module}.server.consultas.Query${class.entityName};

public class ${className} extends AbstractConsulta<${class.entityName}VO> {
    @Override
    public String getQuery() {
        // TODO Auto-generated
        return new StringBuffer()
                .append("SELECT ")
                <#include "attributesQuery.ftl">
                .append("  FROM ${className?upper_case}")
                .toString();
    }
}
