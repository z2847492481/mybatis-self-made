package com.zhq.session.defaults;

import com.zhq.binding.MapperRegistry;
import com.zhq.config.Configuration;
import com.zhq.executor.Executor;
import com.zhq.mapping.BoundSql;
import com.zhq.mapping.Environment;
import com.zhq.mapping.MappedStatement;
import com.zhq.session.SqlSession;
import com.zhq.transaction.TransactionFactory;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhq123
 * @date 2025/2/6 21:24
 */
public class DefaultSqlSession implements SqlSession {

    /**
     * 存储了已经加载的mapper
     */
    private Configuration configuration;

    private Executor executor;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Object selectOne(String statement) {
        return null;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement ms = configuration.getMappedStatement(statement);
        // 通过executor去执行sql并返回结果
        List<T> list = executor.query(ms, parameter, Executor.NO_RESULT_HANDLER, ms.getBoundSql());
        return list.get(0);
    }

    @Override
    public Object getMapper(Class type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
