<#assign className = model.className>
<#assign company = model.company.packageName>
<#assign module = model.modulePackageName>
package ${model.package};

import com.datacoper.arquitetura.server.consultas.AbstractConsulta;
import com.${company}.cooperate.${module}.common.consultas.${model.entityName}VO;
import com.${company}.cooperate.${module}.server.consultas.Query${model.entityName};

public class ${className} extends AbstractConsulta<${model.entityName}VO> {
    @Override
    public String getQuery() {
        StringBuffer sb = new StringBuffer();

        sb.append("SELECT ")
        	.append(" ID${model.entityName?upper_case},")
        	<#list model.attributes as attribute>		
    		.append(" ${attribute.columnName?upper_case}<#if attribute?has_next>,</#if>")
			</#list>
        	.append("  FROM ${model.entityName?upper_case}");

        return sb.toString();
    }
}
