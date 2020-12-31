package cn.jinronga.service.impl;

import cn.jinronga.entity.User;
import cn.jinronga.mapper.UserMapper;
import cn.jinronga.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Author guojinrong
 * @Date 2020/12/31 16:46
 * @Description UserServiceImpl
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo(int id) {
        return userMapper.findUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.findAllUsers();
    }
}
