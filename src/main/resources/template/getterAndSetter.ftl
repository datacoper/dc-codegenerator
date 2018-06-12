<#list attributes as attribute>
    <#assign attributeType = attribute.typeSimpleName>
    <#assign attributeName = attribute.name?uncap_first>
	
    public void set${attributeName?cap_first}(${attributeType} ${attributeName}) {
        this.${attributeName} = ${attributeName};
    }
	
    public ${attributeType} get${attributeName?cap_first}() {
        return ${attributeName};
    }
	
</#list>