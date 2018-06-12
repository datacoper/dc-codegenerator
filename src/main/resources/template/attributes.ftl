<#list model.attributes as attribute>		
    private ${attribute.typeSimpleName} ${attribute.name?uncap_first};
    
</#list>