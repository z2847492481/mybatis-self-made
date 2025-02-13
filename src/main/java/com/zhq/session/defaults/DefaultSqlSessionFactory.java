package com.zhq.session.defaults;

import com.zhq.binding.MapperRegistry;
import com.zhq.config.Configuration;
import com.zhq.executor.Executor;
import com.zhq.mapping.Environment;
import com.zhq.session.SqlSession;
import com.zhq.session.SqlSessionFactory;
import com.zhq.session.TransactionIsolationLevel;
import com.zhq.transaction.Transaction;
import com.zhq.transaction.TransactionFactory;

import java.sql.SQLException;

/**
 * @author zhq123
 * @date 2025/2/6 21:24
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
            // 创建执行器
            final Executor executor = configuration.newExecutor(tx);
            // 创建DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            try {
                assert tx != null;
                tx.close();
            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }
    }
}
