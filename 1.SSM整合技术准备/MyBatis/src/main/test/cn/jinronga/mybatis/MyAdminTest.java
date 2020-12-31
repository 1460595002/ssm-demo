package cn.jinronga.mybatis;

import cn.jinronga.mybatis.entity.Admin;
import cn.jinronga.mybatis.mapper.AdminMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName MyAdminTest
 * @Author guojinrong
 * @Date 2020/12/31 10:57
 * @Description MyAdminTest
 * @Version 1.0
 */
public class MyAdminTest {
    private SqlSession session;

    @Before
    public void before() {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new
                    SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void close() {
        session.commit();
        session.close();
    }

    @Test
    public void testSaveAdmin() {
        AdminMapper mapper = session.getMapper(AdminMapper.class);
        Admin admin = new Admin(1,"超级管理员","12345678");
        int i = mapper.saveAdmin(admin);
        System.out.println(i);
    }
    @Test
    public void testUpdateAdmin() {
        AdminMapper mapper = session.getMapper(AdminMapper.class);
        Admin user = new Admin(1,"周杰伦","1234567338");
        int i = mapper.updateAdmin(user);
        System.out.println(i);
    }
    @Test
    public void testDeleteAdmin(){
        AdminMapper mapper = session.getMapper(AdminMapper.class);
        int i = mapper.deleteAdmin(3);
        System.out.println(i);
    }
    @Test
    public void testGetAdminById(){
        AdminMapper mapper = session.getMapper(AdminMapper.class);
        Admin admin = mapper.findAdminById(1);
        System.out.println(admin);
    }
    @Test
    public void testGetAllAdmins(){
        AdminMapper mapper = session.getMapper(AdminMapper.class);
        List<Admin> admins = mapper.findAllAdmins();
        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }
}
