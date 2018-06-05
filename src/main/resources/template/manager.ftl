<#assign attributes = class.attributes/>
<#assign className = class.className?cap_first>
<#assign classNameUpper = class.className?upper_case>
<#assign module = class.moduleBasic>
<#assign company = class.company.packag>
package ${class.package};

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.datacoper.cooperate.arquitetura.common.dto.AbstractDTO;
import com.datacoper.cooperate.arquitetura.web.generic.form.FormGenericManager;
import com.${company}.cooperate.${module?lower_case}.common.consultas.${class.classNameBasic}VO;
import com.${company}.cooperate.${module?lower_case}.rest.common.dto.${class.classNameBasic}DTO;
import com.${company}.cooperate.integracoescooperalfa.rest.common.resources.${class.classNameBasic}Resource;
<#list class.imports as import>
import ${import};
</#list>

@ManagedBean
@ViewScoped
public class ${className} extends FormGenericManager<${class.classNameBasic}VO, ${class.classNameBasic}DTO, ${class.classNameBasic}Resource> {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected PaginaItemMenuBean getListPageItem() {
        return PaginaItemMenu.${module?upper_case}_${class.classNameBasic?upper_case}_LISTAR;
    }

    @Override
    protected RestConfigurationBase[] getResourceConfiguration() {
        return Enum${module}ResourceConfiguration.values();
    }

    @Override
    public Map<String, String> getFiltersForSelector(String fieldName) {
        //TODO auto-generated
        return Collections.emptyMap();
    }

    @Override
    public Map<String, String> getFiltersForDetailSelector(String idDetailManager, String fieldName) {

        Map<String, String> filters = new HashMap<>();

        //TODO auto-generated

        return filters;
    }

    @Override
    protected void addDefaultListeners() {
        
    }
}