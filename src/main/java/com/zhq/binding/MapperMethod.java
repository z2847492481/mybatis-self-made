package com.zhq.binding;

import com.zhq.config.Configuration;
import com.zhq.mapping.MappedStatement;
import com.zhq.mapping.SqlCommandType;
import com.zhq.session.SqlSession;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 每一个DB操作接口第一次执行的时候，都会生成一个MapperMethod对象
 * MapperMethod对象对象用于判断当前操作是CRUD中的哪一类，然后调用sqlSession进行DB操作
 *
 *
 * @author zhq123
 * @date 2025/2/7 21:17
 */
public class MapperMethod {

    private SqlCommand command;

    public MapperMethod(Class<?> mapperInterface, Method method, Configuration configuration) {
        this.command = new SqlCommand(configuration, mapperInterface, method);
    }

    public Object execute(SqlSession sqlSession, Object[] args) {
        Object result = null;
        switch (command.getType()) {
            case INSERT:
                break;
            case UPDATE:
                break;
            case DELETE:
                break;
            case SELECT:
                result = sqlSession.selectOne(command.getName(), args);
                break;
            default:
                throw new RuntimeException("Unknown execution method for: " + command.getName());

        }
        return result;
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
