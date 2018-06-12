<#assign className = class.className>
<#assign company = class.company.packageName>
<#assign module = class.moduleName?lower_case>
package ${class.package};

import com.datacoper.arquitetura.server.consultas.AbstractConsulta;
import com.${company}.cooperate.${module}.common.consultas.${class.entityName}VO;
import com.${company}.cooperate.${module}.server.consultas.Query${class.entityName};

public class ${className} extends AbstractConsulta<${class.entityName}VO> {
    @Override
    public String getQuery() {
        StringBuffer sb = new StringBuffer();

        sb.append("SELECT ")
        	.append(" ID${class.entityName?upper_case},")
        	<#list class.attributes as attribute>		
    		.append(" ${attribute.name?upper_case}<#if attribute?has_next>,</#if>")
			</#list>
        	.append("  FROM ${class.entityName?upper_case}");

        return sb.toString();
    }
}
