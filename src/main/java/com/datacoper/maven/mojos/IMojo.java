package com.datacoper.maven.mojos;

import com.datacoper.maven.enums.options.CompanyOptions;
import org.apache.maven.plugin.logging.Log;

/**
 * Interface básica do Mojo.
 */
public interface IMojo {

    CompanyOptions getCompany();

    /**
     * O nome da entidade sendo manipulada.
     * @return
     */
    String getEntityName();

    Log getLog();

}