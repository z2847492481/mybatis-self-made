package com.zhq.test;

import com.zhq.datasource.pooled.PooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zhq123
 * @date 2025/2/11 22:25
 */
public class TestPooled {
    public static void main(String[] args) throws SQLException, InterruptedException {
        PooledDataSource pooledDataSource = new PooledDataSource();
        pooledDataSource.setDriver("com.mysql.cj.jdbc.Driver");
        pooledDataSource.setUrl("jdbc:mysql://192.168.10.110:3306/mybatis-study?useUnicode=true");
        pooledDataSource.setUsername("root");
        pooledDataSource.setPassword("root");
        // 持续获得链接
        while (true){
            Connection connection = pooledDataSource.getConnection();
            System.out.println(connection);
            Thread.sleep(1000);
            connection.close();
        }
    }
}
