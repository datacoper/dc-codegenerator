package com.datacoper.maven.mojos;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;

import com.datacoper.maven.enums.properties.EnumProject;
import com.datacoper.maven.exception.DcRuntimeException;
import com.datacoper.maven.util.DCProjectUtil;
import com.datacoper.maven.util.LogUtil;

@Mojo(name = "generate-crud", requiresDependencyResolution = ResolutionScope.RUNTIME)
public class GenerateCrudMojo extends AbstractMojo {

    @Parameter(property = "project", required = true, readonly = true)
    protected MavenProject _project;

    public GenerateCrudMojo() {
        super();
        LogUtil.setLog(getLog());
    }
    
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
    	validate();
        
        try {
            LogUtil.info("\n\nStart plugin {0}");
            
            init();
        } catch(Throwable e) {
            LogUtil.error(e);
        }
    }

    private void init() {
	
    
    }

	public void validate() {
        if (!DCProjectUtil.isProjectType(EnumProject.PARENT, _project)) {
            throw new DcRuntimeException("SKIP - the plugin can only be run from a parent project");
        }
    }
}
