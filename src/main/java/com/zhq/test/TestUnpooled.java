package com.zhq.test;

import com.google.gson.Gson;
import com.zhq.io.Resources;
import com.zhq.session.SqlSession;
import com.zhq.session.SqlSessionFactory;
import com.zhq.session.SqlSessionFactoryBuilder;
import com.zhq.test.dataobj.UserDO;
import com.zhq.test.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author zhq123
 * @date 2025/2/9 19:53
 */
public class TestUnpooled {

    private static final Logger logger = LoggerFactory.getLogger(TestUnpooled.class);


    public static void main(String[] args) throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 3. 测试验证
        for (int i = 0; i < 50; i++) {
            UserDO user = userMapper.getUserById(1L);
            Gson gson = new Gson();
            logger.info("测试结果：{}", gson.toJson(user));
        }
    }
}
