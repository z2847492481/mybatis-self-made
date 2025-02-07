package com.zhq.binding;

import com.zhq.config.Configuration;
import com.zhq.mapping.MappedStatement;
import com.zhq.mapping.SqlCommandType;

import java.lang.reflect.Method;

/**
 * @author zhq123
 * @date 2025/2/7 21:17
 */
public class MapperMethod {

    private SqlCommand command;

    public MapperMethod(Class<?> mapperInterface, Method method, Configuration configuration) {
        this.command = new SqlCommand(configuration, mapperInterface, method);
    }

    /**
     * SQL 指令
     */
    public static class SqlCommand {

        private final String name;
        private final SqlCommandType type;

        public SqlCommand(Configuration configuration, Class<?> mapperInterface, Method method) {
            String statementName = mapperInterface.getName() + "." + method.getName();
            MappedStatement ms = configuration.getMappedStatement(statementName);
            name = ms.getId();
            type = ms.getSqlCommandType();
        }

        public String getName() {
            return name;
        }

        public SqlCommandType getType() {
            return type;
        }
    }
}
