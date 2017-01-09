package com.datacoper.freemarker.conf;

import com.datacoper.maven.exception.DcRuntimeException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;

public class TemplateFreeMarker {

    private Map<String, Object> data;
    private Template template;

    public TemplateFreeMarker(String path, ConfigurationFreeMarker config) {
        this.data = new HashMap<>();
        this.loadTemplate(path, config);
    }

    public void add(String key, Object value) {
        this.data.put(key, value);
    }

    public void generateTemplate(File arquive) {
        try {
            Writer file = new FileWriter(arquive);
            this.template.process(data, file);
            file.flush();
            file.close();
        } catch (Exception e) {
            throw new DcRuntimeException(e);
        }
    }

    private void loadTemplate(String path, ConfigurationFreeMarker config) {
        try {
            this.template = config.getConfiguration().getTemplate(path);
        } catch (TemplateNotFoundException e) {
            e.printStackTrace();
        } catch (MalformedTemplateNameException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
