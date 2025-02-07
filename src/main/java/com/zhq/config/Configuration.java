package com.zhq.config;

import com.zhq.binding.MapperRegistry;
import com.zhq.mapping.MappedStatement;
import com.zhq.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhq123
 * @date 2025/2/7 20:20
 */
public class Configuration<T> {

    private final MapperRegistry mapperRegistry = new MapperRegistry(this);

    private final Map<String, MappedStatement> mappedStatementMap = new HashMap<>();

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession<T> sqlSession) {
        return (T) mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatementMap.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatementMap.get(id);
    }

}
