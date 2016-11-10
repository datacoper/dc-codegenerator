<#assign className = class.className>
<#assign company = class.company.packag>
<#assign module = class.moduleBasic?lower_case>
package ${class.package};

import com.datacoper.arquitetura.server.consultas.AbstractConsulta;
import com.${company}.cooperate.${module}.common.consultas.${class.classNameBasic}VO;
import com.${company}.cooperate.${module}.server.consultas.Query${class.classNameBasic};

public class ${className} extends AbstractConsulta<${class.classNameBasic}VO> {
    @Override
    public String getQuery() {
        //TODO auto generated
        StringBuffer sb = new StringBuffer();

        sb.append("SELECT ");<#include "attributesQuery.ftl">
        sb.append("  FROM ${className?upper_case}");

        return sb.toString();
    }
}
