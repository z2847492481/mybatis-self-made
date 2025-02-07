package com.zhq.session;



import com.zhq.builder.xml.XMLConfigBuilder;
import com.zhq.config.Configuration;
import com.zhq.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @author zhq123
 * @date 2025/2/7 20:52
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration configuration) {
        return new DefaultSqlSessionFactory(configuration);
    }
}
