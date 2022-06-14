package com.example.idiom_backend.service;

import com.example.idiom_backend.bean.UserBean;
import com.example.idiom_backend.mapper.IdiomMapper;
import com.example.idiom_backend.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public boolean signUp(String name, String password, Integer sex) {
        int changed;
        try {
            changed = userMapper.insertUser(name, password, sex);
            return changed == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean signIn(String username, String password) {
        UserBean user = null;
        try {
            user = userMapper.getUser(username, password);
            return user != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
