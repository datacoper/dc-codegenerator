<#assign attributeName = "id" + model.entityName?cap_first>

    public void set${attributeName?cap_first}(Long ${attributeName}) {
        this.${attributeName} = ${attributeName};
    }
	
    public Long get${attributeName?cap_first}() {
        return ${attributeName};
    }