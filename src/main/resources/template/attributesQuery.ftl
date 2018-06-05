<<<<<<< HEAD
<#list class.attributes as attribute>		
    ${attribute.name?upper_case},
=======
<#list attributes as attribute>		
    .append("${attribute.name?upper_case},")
>>>>>>> 6b0e04174f4e85c09815bab8bfc2ea4bcaa95089
</#list>