package com.zhq.session;

/**
 * @author zhq123
 * @date 2025/2/6 21:14
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();

}
