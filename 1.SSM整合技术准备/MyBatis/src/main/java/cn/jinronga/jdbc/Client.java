package cn.jinronga.jdbc;

import cn.jinronga.jdbc.Proxy.InsertProxy;
import cn.jinronga.jdbc.entity.Student;
import cn.jinronga.jdbc.mapper.IStudentDao;

/**
 * @ClassName Client
 * @Author guojinrong
 * @Date 2020/12/30 15:16
 * @Description Client
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        //直接根据接口获取一个代理类
        IStudentDao studentDao = InsertProxy.getProxy(IStudentDao.class);
        studentDao.InsertUser(new Student("9512109","李勇2号","男",20,"数学系"));
    }
}
