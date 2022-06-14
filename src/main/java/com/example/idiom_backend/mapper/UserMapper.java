package com.example.idiom_backend.mapper;

import com.example.idiom_backend.bean.UserBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int insertUser(@Param("username") String username, @Param("password") String password, @Param("sex") Integer sex);
    UserBean getUser(@Param("username") String username, @Param("password") String password);
}
