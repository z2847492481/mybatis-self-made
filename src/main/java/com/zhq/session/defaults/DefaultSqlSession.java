package com.zhq.session.defaults;

import com.zhq.binding.MapperRegistry;
import com.zhq.session.SqlSession;

/**
 * @author zhq123
 * @date 2025/2/6 21:24
 */
public class DefaultSqlSession implements SqlSession {

    /**
     * 存储了已经加载的mapper
     */
    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }


    @Override
    public Object selectOne(String statement) {
        return null;
    }

    @Override
    public Object selectOne(String statement, Object parameter) {
        return null;
    }

    @Override
    public Object getMapper(Class type) {
        return mapperRegistry.getMapper(type, this);
    }
}
