<#list attributes as attribute>		
    private ${attribute.type} ${attribute.name?uncap_first};
    
</#list>