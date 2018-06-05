<#assign className = class.className>
<#assign classVariableName = class.entityName?uncap_first>
<#assign attributes = class.attributes>
<#assign company = class.company.packageName>
<#assign module = class.moduleName?lower_case>
package ${class.package};

import com.${company}.cooperate.${module}.common.entities.${class.entityName};
import com.datacoper.cooperate.arquitetura.common.entities.builder.EntityBuilder;

public class ${className} implements EntityBuilder<${class.entityName}> {
    
    private ${class.entityName} ${classVariableName} = new ${class.entityName}();

    <#include "defaultConstructor.ftl">

    @Override
    public ${class.entityName} build() {
        return ${classVariableName};
    }

<<<<<<< HEAD
    public ${className} withId${classVariableName?cap_first}(Long id${class.entityName}) {
        ${classVariableName}.setId${class.entityName}(id${class.entityName});
=======
    public ${className} withId${classVariableName?cap_first}(Long id${class.classNameBasic}) {
        this.${classVariableName}.setId${class.classNameBasic}(id${class.classNameBasic});
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
        return this;
    }

    <#list attributes as attribute>
    public ${className} with${attribute.name?cap_first}(${attribute.type} ${attribute.name?uncap_first}) {
        this.${classVariableName}.set${attribute.name?cap_first}(${attribute.name?uncap_first});
        return this;
    }

    </#list>
}