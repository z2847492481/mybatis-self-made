package com.zhq;

import com.zhq.binding.MapperRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhq123
 * @date 2025/2/6 21:33
 */
public class Test1 {

    private static final Logger logger = LoggerFactory.getLogger(Test1.class);


    public static void main(String[] args) {
        MapperRegistry mapperRegistry = new MapperRegistry();
        mapperRegistry.addMappers("com.zhq.dao");
        logger.info("success");
    }
}
