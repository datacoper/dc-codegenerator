<#assign className = class.className>
<#assign classVariableName = class.classNameBasic?uncap_first>
<#assign attributes = class.attributes>
<#assign company = class.company.packag>
<#assign module = class.moduleBasic?lower_case>
package ${class.package};

import com.${company}.cooperate.${module}.common.entities.${class.classNameBasic};
import com.datacoper.cooperate.arquitetura.common.entities.builder.EntityBuilder;
<#list class.imports as import>
import ${import};
</#list>

public class ${className} implements EntityBuilder<${class.classNameBasic}> {
    
    private ${class.classNameBasic} ${classVariableName} = new ${class.classNameBasic}();

    <#include "defaultConstructor.ftl">

    @Override
    public ${class.classNameBasic} build() {
        return ${classVariableName};
    }

    public ${className} withId${classVariableName?cap_first}(Long id${class.classNameBasic}) {
        ${classVariableName}.setId${class.classNameBasic}(id${class.classNameBasic});
        return this;
    }

    <#list attributes as attribute>
    public ${className} with${attribute.name?cap_first}(${attribute.type} ${attribute.name?uncap_first}) {
        ${classVariableName}.set${attribute.name?cap_first}(${attribute.name?uncap_first});
        return this;
    }

    </#list>
}