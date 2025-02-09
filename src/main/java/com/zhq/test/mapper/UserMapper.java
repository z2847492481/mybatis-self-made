package com.zhq.test.mapper;

/**
 * @author zhq123
 * @date 2025/2/6 20:31
 */
import com.zhq.test.dataobj.UserDO;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    UserDO getUserById(@Param("id") Long id);
}

