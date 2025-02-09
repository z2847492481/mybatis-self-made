package com.zhq.session;

import java.sql.Connection;

/**
 * @author zhq123
 * @date 2025/2/9 12:33
 */
public enum TransactionIsolationLevel {

    NONE(Connection.TRANSACTION_NONE),

    READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),

    READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),

    REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),

    SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);

    private final int level;

    TransactionIsolationLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
