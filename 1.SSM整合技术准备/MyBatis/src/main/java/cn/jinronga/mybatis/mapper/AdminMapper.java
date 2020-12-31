package cn.jinronga.mybatis.mapper;

import cn.jinronga.mybatis.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName AdminMapper
 * @Author guojinrong
 * @Date 2020/12/31 10:30
 * @Description AdminMapper
 * @Version 1.0
 */
public interface AdminMapper {
    /**
     * 保存管理员
     *
     * @param admin
     * @return
     */
    @Insert("insert into [admin] (id,username,password) values (#{id},#{username},#{password})")
    int saveAdmin(Admin admin);

    /**
     * 跟新管理员
     *
     * @param admin
     * @return
     */
    @Update("update [admin] set username=#{username} , password=#{password} where id =#{id}")
    int updateAdmin(Admin admin);

    /**
     * 删除管理员
     *
     * @param id
     * @return
     */

    @Delete("delete from [admin] where id=#{id}")
    int deleteAdmin(int id);

    /**
     * 根据id查找管理员
     *
     * @param id
     * @return
     */
    @Select("select id,username,password from [admin] where id=#{id}")
    Admin findAdminById(@Param("id") int id);

    /**
     * 查询所有的管理员
     *
     * @return
     */
    @Select("select id,username,password from [admin]")
    List<Admin> findAllAdmins();
}
