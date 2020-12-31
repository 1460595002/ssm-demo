package cn.jinronga.mapper;

import cn.jinronga.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     */
    User findUserById(int id);

    /**
     * 获取所有的用户
     *
     * @return
     */
    List<User> findAllUsers();
}