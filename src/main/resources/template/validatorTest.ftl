<#assign className = model.className>
package ${model.package};

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.datacoper.testes.mock.MockRunner;
<#list model.imports as import>
import ${import};
</#list>

@RunWith(MockRunner.class)
public class ${className} {
    Validador${model.classNameBasic} validador${model.classNameBasic} = new Validador${model.classNameBasic}();

    @Test
    public void teste() {
        fail("Método Gerado automaticamente.");
    }
}