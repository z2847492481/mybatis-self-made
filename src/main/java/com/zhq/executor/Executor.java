package com.zhq.executor;

import com.zhq.mapping.BoundSql;
import com.zhq.mapping.MappedStatement;
import com.zhq.session.ResultHandler;
import com.zhq.transaction.Transaction;

import java.sql.SQLException;
import java.util.List;

/**
 * @author zhq123
 * @date 2025/2/13 22:10
 */
public interface Executor {

    ResultHandler NO_RESULT_HANDLER = null;

    <E> List<E> query(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql);

    Transaction getTransaction();

    void commit(boolean required) throws SQLException;

    void rollback(boolean required) throws SQLException;

    void close(boolean forceRollback);
}
