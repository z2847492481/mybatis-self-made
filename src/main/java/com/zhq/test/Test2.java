package com.zhq.test;

import com.google.gson.Gson;
import com.zhq.builder.xml.XMLConfigBuilder;
import com.zhq.config.Configuration;
import com.zhq.io.Resources;
import com.zhq.session.SqlSession;
import com.zhq.session.defaults.DefaultSqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * @author zhq123
 * @date 2025/2/9 14:08
 */
public class Test2 {

    private static final Logger logger = LoggerFactory.getLogger(Test2.class);


    public static void main(String[] args) throws IOException {
        // 解析 XML
//        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
//        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
//        Configuration configuration = xmlConfigBuilder.parse();
//        // 获取 DefaultSqlSession
//        SqlSession sqlSession = new DefaultSqlSession(configuration);
//        // 执行查询：默认是一个集合参数
//        Object[] req = {1L};
//        Object res = sqlSession.selectOne("com.zhq.test.mapper.UserMapper.getUserById", req);
//        Gson gson = new Gson();
//        logger.info("测试结果：{}", gson.toJson(res));
    }
}
