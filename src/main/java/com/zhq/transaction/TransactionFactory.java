package com.zhq.transaction;

import com.zhq.session.TransactionIsolationLevel;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author zhq123
 * @date 2025/2/9 12:46
 */
public interface TransactionFactory {

    Transaction newTransaction(Connection connection);

    /**
     * 根据 数据源&隔离级别&自动提交 创建事务
     * @param dataSource
     * @param level
     * @param autoCommit
     * @return
     */
    Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit);
}
