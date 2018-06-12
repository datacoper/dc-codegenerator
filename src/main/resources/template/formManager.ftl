<#assign className = model.className>
<#assign company = model.company.packag>
<#assign module = model.moduleBasic>
package ${model.package};

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
import com.${company}.cooperate.${module?lower_case}.common.consultas.${model.classNameBasic}VO;
import com.${company}.cooperate.${module?lower_case}.rest.common.dto.${model.classNameBasic}DTO;
import com.${company}.cooperate.${module?lower_case}.rest.common.resources.${model.classNameBasic}Resource;

@ManagedBean
@ViewScoped
public class Form${model.classNameBasic}Manager extends FormGenericManager<${model.classNameBasic}VO, ${model.classNameBasic}DTO, ${model.classNameBasic}Resource> {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected PaginaItemMenuBean getListPageItem() {
        return PaginaItemMenu.${module?upper_case}_${model.classNameBasic?upper_case}_LISTAR;
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

