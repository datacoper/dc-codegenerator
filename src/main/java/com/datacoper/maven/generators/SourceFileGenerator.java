package com.datacoper.maven.generators;

import static com.datacoper.maven.util.SystemUtil.getFileSeparator;

import java.io.File;

import org.apache.maven.project.MavenProject;

import com.datacoper.freemarker.conf.ConfigurationFreeMarker;
import com.datacoper.freemarker.conf.TemplateFreeMarker;
import com.datacoper.maven.exception.DcRuntimeException;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.util.ConsoleUtil;
import com.datacoper.maven.util.FileUtil;
import com.datacoper.maven.util.LogUtil;
import com.datacoper.maven.util.MavenUtil;

public final class SourceFileGenerator {

    private final TemplateFreeMarker template;
    
    private final MavenProject project;
    
    private final TClass data;

    private String encoding;

    private SourceFileGenerator(MavenProject project, String templateName, TClass data, String encoding) {
        this.project = project;
        this.template = initTemplate(templateName);
        this.data = data;
        this.encoding = encoding;

        // Passa os dados da classe para o arquivo template
        template.add("class", data);
    }

    private TemplateFreeMarker initTemplate(String templateName) {
        ConfigurationFreeMarker config = new ConfigurationFreeMarker();

        return new TemplateFreeMarker(templateName + ".ftl", config);
    }
    
    private void process() {
        String pathClass = createFolderForGeneratedFiles();

        ConsoleUtil.sysOutl("*****************\n\n");
        
        LogUtil.info("generating file {0}", pathClass);
        
        File arquive = createAndValidateNewFile(pathClass);
        
        template.generateTemplate(arquive, encoding);
        
        LogUtil.info("generated file");
    }

    private String createFolderForGeneratedFiles() {
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

    public static void generate(MavenProject project, String templateName, TClass data) {
        generate(project, templateName, data, "ISO-8859-1");
    }

    public static void generate(MavenProject project, String templateName, TClass data, String charset) {
        new SourceFileGenerator(project, templateName, data, charset).process();
    }
}
