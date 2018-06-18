<#assign className = model.className>
<#assign classVariableName = model.entityName?uncap_first>
<#assign attributes = model.attributes>
<#assign company = model.company.packageName>
<#assign module = model.modulePackageName>
package ${model.package};

<#include "attributeImports.ftl">

import com.datacoper.cooperate.arquitetura.common.entities.builder.EntityBuilder;
import ${model.entityType};

public class ${className} implements EntityBuilder<${model.entityName}> {
    
    private ${model.entityName} ${classVariableName} = new ${model.entityName}();

    <#include "defaultConstructor.ftl">

    @Override
    public ${model.entityName} build() {
        return ${classVariableName};
    }

    public ${className} withId${classVariableName?cap_first}(Long id${model.entityName}) {
        ${classVariableName}.setId${model.entityName}(id${model.entityName});
        return this;
    }

    <#list model.attributes as attribute>
    public ${className} with${attribute.name?cap_first}(${attribute.typeSimpleName} ${attribute.name?uncap_first}) {
        ${classVariableName}.set${attribute.name?cap_first}(${attribute.name?uncap_first});
        return this;
    }

    </#list>
}