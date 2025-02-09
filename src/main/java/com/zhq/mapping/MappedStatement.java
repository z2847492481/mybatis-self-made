package com.zhq.mapping;

import com.zhq.config.Configuration;

import java.util.Map;

/**
 * @author zhq123
 * @date 2025/2/7 20:21
 */
public class MappedStatement {

    private Configuration configuration;

    private String id;

    private SqlCommandType sqlCommandType;

    private BoundSql boundSql;

    public MappedStatement() {
    }

    public static class Builder {

        private MappedStatement mappedStatement = new MappedStatement();

        public Builder(Configuration configuration, String id, SqlCommandType sqlCommandType, BoundSql boundSql) {
            mappedStatement.configuration = configuration;
            mappedStatement.id = id;
            mappedStatement.sqlCommandType = sqlCommandType;
        }

        public MappedStatement build() {
            assert mappedStatement.configuration != null;
            assert mappedStatement.id != null;
            return mappedStatement;
        }
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public String getId() {
        return id;
    }

    public SqlCommandType getSqlCommandType() {
        return sqlCommandType;
    }

    public BoundSql getBoundSql() {
        return boundSql;
    }
}
