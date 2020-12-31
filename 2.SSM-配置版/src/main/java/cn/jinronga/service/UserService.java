package cn.jinronga.service;

import cn.jinronga.entity.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Author guojinrong
 * @Date 2020/12/31 16:44
 * @Description UserService
 * @Version 1.0
 */
public interface UserService {
    /**
     * 获取一个用户的信息
     * @param id
     * @return
     */
    User getUserInfo(int id);
    /**
     * 获取所有用户信息
     * @return
     */
    List<User> getAllUsers();
}
