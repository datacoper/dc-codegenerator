/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datacoper.maven.generators;

import com.datacoper.maven.util.LogUtil;
import java.util.List;

/**
 *
 * @author alessandro
 */
public abstract class AbstractGroupGenerator implements IGenerator {
    private final List<? extends IGenerator> generators;
    
    public AbstractGroupGenerator(List<? extends IGenerator> generators) {
        this.generators = generators;
    }

    @Override
    public void generate() {
        generators.forEach(generator -> {
            try {
                generator.generate();
            } catch (Throwable e) {
                LogUtil.error(e);
            }
        });
    }
}
