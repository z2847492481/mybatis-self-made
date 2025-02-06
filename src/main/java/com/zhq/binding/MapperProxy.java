package com.zhq.binding;

import com.zhq.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhq123
 * @date 2025/2/5 21:28
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {


    private static final long serialVersionUID = -2586193361064781031L;

    /**
     * key是接口名+方法名
     */
    private SqlSession sqlSession;

    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Object的一些方法不进行代理
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            return String.format("你被代理了:{0}", sqlSession.selectOne(method.getName()));
        }
    }
}
