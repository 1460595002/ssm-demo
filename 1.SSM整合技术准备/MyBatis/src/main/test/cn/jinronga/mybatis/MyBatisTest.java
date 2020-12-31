package cn.jinronga.mybatis;

import cn.jinronga.mybatis.entity.User;
import cn.jinronga.mybatis.mapper.UserMapper;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class MyBatisTest {

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
    public void commit() {
//统一提交事务
        session.commit();
        session.close();
    }

    @Test
    public void testFindUserById() {
        try {
            String resource = "mybatis-config.xml";
            //输入流获取配置文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
            /**
             * SqlSessionFactory是MyBatis的关键对象,它是个单个数据库映射关系经过编译后的内存镜像
             * .SqlSessionFactory对象的实例可以通过SqlSessionFactoryBuilder对象类获得,
             * 而SqlSessionFactoryBuilder则可以从XML配置文件或一个预先定制的Configuration
             * 的实例构建出SqlSessionFactory的实例.每一个MyBatis的应用程序都以一个SqlSessionFactory对象的实例为核心.
             * 同时SqlSessionFactory也是线程安全的,SqlSessionFactory一旦被创建,
             * 应该在应用执行期间都存在.在应用运行期间不要重复创建多次,建议使用单例模式.SqlSessionFactory是创建SqlSession的工厂.
             */
            SqlSessionFactory sqlSessionFactory = new
                    SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            //获取UserMapper接口
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.selectUserById(1);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSelectUserById() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(2);
        System.out.println(user);
    }
    @Test
    public void testAddUser() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(2, "jinronga", "12345678");
        int affectedRows = mapper.addUser(user);
        System.out.println(affectedRows);
    }

    @Test
    public void testAddUser1() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        int affectedRows = mapper.addUser1(3, "金融果果", "23434");
        System.out.println(affectedRows);
    }

    @Test
    public void testUpdateUser() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(2, "周杰伦111", "12345678");
        int affectedRows = mapper.updateUser(user);
        System.out.println(affectedRows);
    }

    @Test
    public void testDeleteUser() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        int affectedRows = mapper.deleteUser(3);
        System.out.println(affectedRows);
    }
    @Test
    public void SelectListUser() {
        UserMapper mapper = session.getMapper(UserMapper.class);
        HashMap<String, String> map = new HashMap<>();
        map.put("username","周杰伦");

        List<User> usersByParams = mapper.getUsersByParams(map);
        System.out.println(usersByParams);

    }
    @Test
    public void SortTest() {
        int[] arr = new int[]{23, 56, 3, 334, 77, 56, 24, 86, 34, 53};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                //如果前面的数大于后面的则进行交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}