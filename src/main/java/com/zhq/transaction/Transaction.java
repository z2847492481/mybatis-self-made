package com.zhq.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zhq123
 * @date 2025/2/8 21:46
 */
public interface Transaction {

    Connection getConnection() throws SQLException;

    void commit() throws SQLException;

    void rollback() throws SQLException;

    void close() throws SQLException;
}
