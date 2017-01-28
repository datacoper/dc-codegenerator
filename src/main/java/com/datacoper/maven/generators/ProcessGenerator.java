package com.datacoper.maven.generators;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
		process(Arrays.asList(generators));
	}
	
	@SuppressWarnings("unchecked")
	public void process(Class<? extends AbstractGenerator<TClass>>... generators) {
		List<AbstractGenerator<TClass>> listGenerators = Arrays.asList(generators)
				.stream()
				.map(this::getConstructor)
				.map(this::createInstance)
				//.filter(generator -> generator.getProjectTypeForGenerate()) TODO filtrar para só gerar classes do respectivo modulo
				.collect(Collectors.toList());
		
		process(listGenerators);
	}

	//TODO espera-se que as classes sejam sempre instanciadas corretamente, precisa tratar erros
	public void process(EnumGroupGenerators groupGenerator) {	
		process(groupGenerator.getGenerators());
	}
	
	public void process(List<? extends AbstractGenerator<?>> generators) {
		generators
			.forEach(generator -> {					
				try {
					generator.generate();
				} catch (Throwable e) {
					LogUtil.warn(e.getMessage());
				}
			});
	}

	private AbstractGenerator<TClass> createInstance(Constructor<? extends AbstractGenerator<TClass>> constructor) {
		try {
			return constructor.newInstance(project, data);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			LogUtil.error(e);
		}
		
		return null;
	}

	private Constructor<? extends AbstractGenerator<TClass>> getConstructor(Class<? extends AbstractGenerator<TClass>> clazz) {
		try {
			return clazz.getConstructor(MavenProject.class, TClass.class);
		} catch (NoSuchMethodException | SecurityException e) {
			LogUtil.error(e);
		}
		
		return null;
	}
}
