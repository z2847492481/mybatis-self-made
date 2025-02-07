package com.zhq.builder;

import com.zhq.config.Configuration;

/**
 * @author zhq123
 * @date 2025/2/7 20:55
 */
public abstract class BaseBuilder<T> {

    protected final Configuration<T> configuration;

    public BaseBuilder(Configuration<T> configuration) {
        this.configuration = configuration;
    }

    public Configuration<T> getConfiguration() {
        return configuration;
    }
}
