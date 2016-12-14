<#assign className = class.className>
package ${class.package};

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.datacoper.testes.mock.MockRunner;
<#list class.imports as import>
import ${import};
</#list>

@RunWith(MockRunner.class)
public class ${className} {
    Validador${class.classNameBasic} validador${class.classNameBasic} = new Validador${class.classNameBasic}();

    @Test
    public void teste() {
        fail("Método Gerado automaticamente.");
    }
}