package com.datacoper.maven.mojos;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import com.datacoper.maven.enums.options.CompanyOptions;
import com.datacoper.maven.generators.AbstractGenerator;
import com.datacoper.maven.generators.ProcessGenerator;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.util.ClassLoaderUtil;
import com.datacoper.maven.util.ConsoleUtil;
import com.datacoper.maven.util.LogUtil;

public abstract class AbstractDCMojo extends AbstractMojo implements IMojo {

	@Parameter(defaultValue = "${session}")
	protected MavenSession session;
	
    @Parameter(property = "project", required = true, readonly = true)
    protected MavenProject _project;

    @Parameter(property = "class", defaultValue = MojoConstants.PROPERTY_NOT_INFORMED)
    protected String _completeEntityName;

    @Parameter(property = "entidade")
    protected String entityName;

    @Parameter(property = "company", readonly=true)
    private String company;

    public AbstractDCMojo() {
        super();
        LogUtil.setLog(getLog());
    }
    
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {        
        try {
            LogUtil.info("\n\nStart plugin {0}", getMojoName());
            
            important();
            
            ClassLoaderUtil.loadClassLoader(_project);
        } catch(Throwable e) {
            LogUtil.error(e);
        }
    }

    private void important() {
        ConsoleUtil.sysOutl("\n********************************************************************************************************************\n\n");
    }

    public void init() {
    	TClass clazz = (TClass) session.getUserProperties().get("tclazz");
    	
    	if (clazz == null) {
    		clazz = getTClassWithWizard();
    		
    		session.getUserProperties().put("tclazz", clazz);
    	}
    	
        new ProcessGenerator(_project, clazz).process(getGenerators());
    }
    
    public abstract String getMojoName();
    
    /* (non-Javadoc)
     * @see com.datacoper.maven.mojos.IMojo#getCompanyParameter()
     */
    @Override
    public CompanyOptions getCompany() {
        return company != null ? CompanyOptions.of(Integer.valueOf(company)) : null;
    }

    @Override
    public String getEntityName() {
        return entityName;
    }

	public abstract TClass getTClassWithWizard();

	public abstract Class<? extends AbstractGenerator<TClass>>[] getGenerators();
	
	@SuppressWarnings("unchecked")
	protected Class<? extends AbstractGenerator<TClass>>[] convert(Class<? extends AbstractGenerator<TClass>>... classes) {
		return classes;
	}
}
