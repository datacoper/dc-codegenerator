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
@Mojo(name = "server", requiresDependencyResolution = ResolutionScope.RUNTIME)
public class ServerClassesGeneratorMojo extends AbstractGroupGeneratorMojo {

    protected ServerClassesGeneratorMojo() {
        super(EnumDCProjectType.SERVER);
    }
}
