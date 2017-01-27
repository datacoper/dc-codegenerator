package com.datacoper.maven.generators;

import java.util.Arrays;

import org.apache.maven.project.MavenProject;

import com.datacoper.maven.generators.impl.EnumGroupGenerators;
import com.datacoper.maven.metadata.TClass;
import com.datacoper.maven.util.LogUtil;

public class ProcessGenerator {
	
	private final MavenProject project;
	
	private final TClass data;
	
	public ProcessGenerator(MavenProject project, TClass data) {
		this.project = project;
		this.data = data;
	}
	
	public void process(AbstractGenerator<?>... generators) {
		Arrays.asList(generators)
				.forEach(generator -> {					
					generator.generate();
				});
	}

	public void process(EnumGroupGenerators groupGenerator) {		
		Arrays.asList(groupGenerator.getGenerators())
				.forEach(clazz -> {
					try {
						AbstractGenerator<TClass> generator = clazz.getConstructor(MavenProject.class, TClass.class).newInstance(project, data);
						
						process(generator);
					} catch (Exception e) {
						LogUtil.error(e);
					}
				});
	}
}
