<#assign className = class.className>
<#assign company = class.company.packageName>
<#assign module = class.moduleBasic?lower_case>
package ${class.package};

import com.datacoper.arquitetura.server.consultas.AbstractConsulta;
import com.${company}.cooperate.${module}.common.consultas.${class.entityName}VO;
import com.${company}.cooperate.${module}.server.consultas.Query${class.entityName};

public class ${className} extends AbstractConsulta<${class.entityName}VO> {
    @Override
    public String getQuery() {
        //TODO auto generated
        StringBuffer sb = new StringBuffer();

        sb.append("SELECT ");<#include "attributesQuery.ftl">
        sb.append("  FROM ${className?upper_case}");

        return sb.toString();
    }
}
