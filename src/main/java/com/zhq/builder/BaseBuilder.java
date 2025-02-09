package com.zhq.builder;

import com.zhq.config.Configuration;
import com.zhq.type.TypeAliasRegistry;

/**
 * @author zhq123
 * @date 2025/2/7 20:55
 */
public abstract class BaseBuilder<T> {

    protected final Configuration<T> configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration<T> configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration<T> getConfiguration() {
        return configuration;
    }
}
