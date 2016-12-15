<#list attributes as attribute>		
    .append("${attribute.name?upper_case},")
</#list>