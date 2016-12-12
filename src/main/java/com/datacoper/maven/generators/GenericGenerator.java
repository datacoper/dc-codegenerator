package com.datacoper.maven.generators;

import org.apache.maven.project.MavenProject;

import com.datacoper.freemaker.conf.ConfigurationFreeMarker;
import com.datacoper.freemaker.conf.TemplateFreeMarker;
import com.datacoper.maven.exception.DcRuntimeException;
import com.datacoper.maven.metadata.TAbstract;
import com.datacoper.maven.util.ConsoleUtil;
import com.datacoper.maven.util.FileUtil;
import com.datacoper.maven.util.LogUtil;
import com.datacoper.maven.util.MavenUtil;
import java.io.File;
import static com.datacoper.maven.util.SystemUtil.*;

public final class GenericGenerator {

    private final TemplateFreeMarker template;
    
    private final MavenProject project;
    
    private final TAbstract data;
    
    private GenericGenerator(MavenProject project, String templateName, TAbstract data) {
        this.project = project;
        this.template = initTemplate(templateName);
        this.data = data;
        
        template.add("class", data);
    }

    private TemplateFreeMarker initTemplate(String templateName) {
        ConfigurationFreeMarker config = new ConfigurationFreeMarker();
        
        return new TemplateFreeMarker(templateName + ".ftl", config);
    }
    
    private void process() {
        String folderClass = MavenUtil.getPathForPackage(project, data.getPackage());

        FileUtil.createFolderIfNecessary(folderClass);

        String className = data.getClassName().concat(".java");
        
        String pathClass = folderClass.concat(getFileSeparator()).concat(className);

        System.out.println("\n*****************\n");
        
        LogUtil.info("generating class {0}", pathClass);
        
        File arquive = createAndValidateNewFile(pathClass);
        
        template.generateTemplate(arquive);
        
        LogUtil.info("\ngenerated class");
    }

    private File createAndValidateNewFile(String pathClass) {
        File arquive = new File(pathClass);
        
        if (arquive.exists()) {            
            throw new DcRuntimeException("class already exists and will not be generated");
        }
        
        return arquive;
    }

    public static void generate(MavenProject project, String templateName, TAbstract data) {
        new GenericGenerator(project, templateName, data).process();
    }
}
