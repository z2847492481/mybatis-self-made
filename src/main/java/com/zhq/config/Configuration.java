package com.zhq.config;

import com.zhq.binding.MapperRegistry;
import com.zhq.datasource.druid.DruidDataSourceFactory;
import com.zhq.datasource.pooled.PooledDataSourceFactory;
import com.zhq.datasource.unpooled.UnpooledDataSourceFactory;
import com.zhq.mapping.Environment;
import com.zhq.mapping.MappedStatement;
import com.zhq.session.SqlSession;
import com.zhq.transaction.jdbc.JdbcTransactionFactory;
import com.zhq.type.TypeAliasRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhq123
 * @date 2025/2/7 20:20
 */
public class Configuration<T> {

    //环境
    protected Environment environment;

    private final MapperRegistry mapperRegistry = new MapperRegistry(this);

    private final Map<String, MappedStatement> mappedStatementMap = new HashMap<>();

    // 类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    public Configuration() {
        // 配置文件中事务管理器的映射
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        // 配置文件中数据源的映射
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
        // 无池化连接池
        typeAliasRegistry.registerAlias("UNPOOLED", UnpooledDataSourceFactory.class);
        // 无池化连接池
        typeAliasRegistry.registerAlias("POOLED", PooledDataSourceFactory.class);
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
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

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
