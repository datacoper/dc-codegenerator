/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.mojos.agrupado;

import com.datacoper.maven.enums.properties.EnumDCProjectType;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

/**
 *
 * @author Roberto Filho
 */
@Mojo(name = "entidade", requiresDependencyResolution = ResolutionScope.RUNTIME)
public class EntidadeGeneratorMojo extends AbstractGroupGeneratorMojo {

    public EntidadeGeneratorMojo() {
        super(EnumDCProjectType.COMMON);
    }
}
