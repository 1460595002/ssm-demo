package cn.jinronga.mybatis.mapper;

import cn.jinronga.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserMapper
 * @Author guojinrong
 * @Date 2020/12/30 16:51
 * @Description UserMapper
 * @Version 1.0
 */
public interface UserMapper {
    //根据id查询用户
    User selectUserById(int id);

    //新增user
    int addUser(User user);

    //新增用户
    int addUser1(@Param("id") int id, @Param("username") String username, @Param("password") String password);

    //更新用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

    //根据一些参数查询
    List<User> getUsersByParams(Map<String, String> map);
}
