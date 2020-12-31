package cn.jinronga.jdbc.mapper;

import cn.jinronga.jdbc.entity.Student;

/**
 * @ClassName IUserDao
 * @Author guojinrong
 * @Date 2020/12/30 15:10
 * @Description IUserDao
 * @Version 1.0
 */
public interface IStudentDao {
    /**
     * 添加学生
     *
     * @param student
     */
    void InsertUser(Student student);
}
