package com.datacoper.maven.generators;

import com.datacoper.freemarker.conf.ConfigurationFreeMarker;
import com.datacoper.freemarker.conf.TemplateFreeMarker;
import com.datacoper.maven.exception.DcRuntimeException;
import com.datacoper.maven.metadata.TAbstract;
import com.datacoper.maven.util.ConsoleUtil;
import com.datacoper.maven.util.FileUtil;
import com.datacoper.maven.util.LogUtil;
import com.datacoper.maven.util.MavenUtil;
import org.apache.maven.project.MavenProject;

import java.io.File;

import static com.datacoper.maven.util.SystemUtil.getFileSeparator;

public final class SourceFileGenerator {

    private final TemplateFreeMarker template;
    
    private final MavenProject project;
    
    private final TAbstract data;
    
    private SourceFileGenerator(MavenProject project, String templateName, TAbstract data) {
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
        String pathClass = generatePathForFile();

        ConsoleUtil.sysOutl("\n*****************\n");
        
        LogUtil.info("generating file {0}", pathClass);
        
        File arquive = createAndValidateNewFile(pathClass);
        
        template.generateTemplate(arquive);
        
        LogUtil.info("\ngenerated file");
    }

    private String generatePathForFile() {
        SourceType sourceType = data.getSourceType();
        
        String folderClass = MavenUtil.getSourcePathForPackage(project, data.getPackage(), sourceType);
        
        FileUtil.createFolderIfNecessary(folderClass);
        
        String className = data.getClassName().concat(".").concat(sourceType.getFileExtension());
        
        return folderClass.concat(getFileSeparator()).concat(className);
    }

    private File createAndValidateNewFile(String pathClass) {
        File arquive = new File(pathClass);
        
        if (arquive.exists()) {            
            throw new DcRuntimeException("class already exists and will not be generated");
        }
        
        return arquive;
    }

    public static void generate(MavenProject project, String templateName, TAbstract data) {
        new SourceFileGenerator(project, templateName, data).process();
    }
}
