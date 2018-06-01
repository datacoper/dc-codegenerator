<#assign className = class.className>
<#assign module = class.moduleBasic?lower_case>
<#assign company = class.company.packageName>
package ${class.package};

import com.datacoper.cooperate.arquitetura.common.exception.MandatoryFieldsException;
import com.${company}.cooperate.${module}.common.entities.${class.entityName};
import com.datacoper.cooperate.arquitetura.common.util.ValidateMandatoryFields;
<#list class.imports as import>
import ${import};
</#list>

public class ${className} {
    
    <#include "defaultConstructor.ftl">

    public void requiredFields(${class.entityName} ${class.entityName?uncap_first}) throws MandatoryFieldsException {
        new ValidateMandatoryFields()
        <#list class.attributes as attribute>
                .add(${class.entityName?uncap_first}.get${attribute.name?cap_first}(), "${attribute.name}")
                <#if !attribute?has_next>.doValidate()</#if>                
        </#list>
        ;
    }
}