<#list attributes as attribute>
    <#assign attributeType = attribute.type>
    <#assign attributeName = attribute.name?uncap_first>
    <#include "methodGetter.ftl">

    <#include "methodSetter.ftl">

</#list>