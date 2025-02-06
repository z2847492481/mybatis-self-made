package com.zhq.session.defaults;

import com.zhq.binding.MapperRegistry;
import com.zhq.session.SqlSession;
import com.zhq.session.SqlSessionFactory;

/**
 * @author zhq123
 * @date 2025/2/6 21:24
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
