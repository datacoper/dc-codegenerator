package ${class.package};

<#list class.imports as import>
import ${import};
</#list>

@Entity
public class ${class.simpleName}<#if class.superClass??> extends ${class.superClass.simpleName}</#if> {

    @SequenceGenerator(name = SEQ_${class.simpleName?upper_case}, sequenceName = "ID${class.simpleName?upper_case}")
    private Long id${class.simpleName?cap_first};

    <#global attributes = class.attributes/>

    <#include "attributes.ftl">

    <#include "defaultConstructor.ftl">

    <#include "getterAndSetter.ftl">
}