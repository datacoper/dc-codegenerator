<#assign className = class.className>
<#assign company = class.company.packag>
<#assign module = class.moduleBasic>
package ${class.package};

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.datacoper.arquitetura.common.itemmenu.PaginaItemMenu;
import com.datacoper.arquitetura.common.itemmenu.PaginaItemMenuBean;
import com.datacoper.cooperate.arquitetura.web.generic.form.FormGenericManager;
import com.datacoper.cooperate.arquitetura.web.generic.form.RestConfigurationBase;

import com.${company}.cooperate.${module?lower_case}.web.Enum${module}ResourceConfiguration;
import com.${company}.cooperate.${module?lower_case}.common.consultas.${class.classNameBasic}VO;
import com.${company}.cooperate.${module?lower_case}.rest.common.dto.${class.classNameBasic}DTO;
import com.${company}.cooperate.${module?lower_case}.rest.common.resources.${class.classNameBasic}Resource;

@ManagedBean
@ViewScoped
public class Form${class.classNameBasic}Manager extends FormGenericManager<${class.classNameBasic}VO, ${class.classNameBasic}DTO, ${class.classNameBasic}Resource> {
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
        return Collections.emptyMap();
    }

    @Override
    public Map<String, String> getFiltersForDetailSelector(String idDetailManager, String fieldName) {
        Map<String, String> filters = new HashMap<>();

        return filters;
    }

    @Override
    protected void addDefaultListeners() {
        
    }
}

