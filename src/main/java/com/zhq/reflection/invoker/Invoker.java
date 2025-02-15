package com.zhq.reflection.invoker;

/**
 * @author zhq123
 * @date 2025/2/15 12:31
 */
public interface Invoker {

    Object invoke(Object target, Object[] args) throws Exception;

    Class<?> getType();
}
