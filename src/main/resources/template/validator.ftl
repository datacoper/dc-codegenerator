<#assign className = class.className>
<#assign module = class.moduleBasic?lower_case>
<#assign company = class.company.packag>
package ${class.package};

import com.${company}.cooperate.${module}.common.entities.${class.classNameBasic};
import com.datacoper.cooperate.arquitetura.common.util.ValidateMandatoryFields;
<#list class.imports as import>
import ${import};
</#list>

public class ${className} {
    
    <#include "defaultConstructor.ftl">

    public void validateRequiredFields(${class.classNameBasic} ${class.classNameBasic?uncap_first}) {
        new ValidateMandatoryFields()
        <#list class.attributes as attribute>
                .add(${class.classNameBasic?uncap_first}.get${attribute.name?cap_first}(), "${attribute.name}")
        </#list>
                .validate();
    }
}