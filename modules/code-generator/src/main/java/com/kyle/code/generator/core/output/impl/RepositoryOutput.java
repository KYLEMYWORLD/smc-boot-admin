package com.kyle.code.generator.core.output.impl;

import com.kyle.code.generator.core.config.strategy.IStrategy;
import com.kyle.code.generator.core.engine.AbstractTemplateEngine;
import com.kyle.code.generator.core.enums.OutputFile;
import com.kyle.code.generator.core.output.AbstractOutput;

import java.io.File;

/**
 * Repository 输出
 *
 * @author kyle
 * @date 2024/5/28
 */
public class RepositoryOutput extends AbstractOutput {
    private final AbstractTemplateEngine engine;

    public RepositoryOutput(AbstractTemplateEngine engine) {
        super(engine);
        this.engine = engine;
    }

    @Override
    protected OutputFile getOutputFile() {
        return OutputFile.repository;
    }

    @Override
    protected String getFilePath(String entityName) {
        String filename = this.getStrategyConfig().getConverterFileName().converter(entityName);
        String pathInfo = getPathInfo(getOutputFile());
        return pathInfo + File.separator + filename + ".java";
    }

    @Override
    protected String getTemplatePath() {
        return engine.templateFilePath(getStrategyConfig().getJavaTemplate());
    }

    @Override
    protected IStrategy getStrategyConfig() {
        return engine
                .getConfigBuilder()
                .getStrategyConfig()
                .getRepositoryStrategy();
    }
}
