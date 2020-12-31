package cn.jinronga.jdbc.Proxy;

import cn.jinronga.jdbc.utils.DBUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ClassName InsertProxy
 * @Author guojinrong
 * @Date 2020/12/30 15:13
 * @Description InsertProxy
 * @Version 1.0
 */
//全国统一的插入代理
public class InsertProxy implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //使用参数（就用第一个）实体类拼装sql（insert）
        StringBuilder sql = new StringBuilder("insert into ");
        sql.append(args[0].getClass().getSimpleName().toLowerCase())
                .append(" values (");
        Field[] fields = args[0].getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType() == int.class) {
                try {
                    sql.append(field.getInt(args[0])).append(",");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if (field.getType() == String.class) {
                try {
                    sql.append("'").append(field.get(args[0])).append("',");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        //执行sql
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rows = 0;
        try {
            connection = DBUtil.getConnection();
            sql.deleteCharAt(sql.length() - 1).append(")");
            preparedStatement = connection.prepareStatement(sql.toString());
            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, preparedStatement, null);
        }
        System.out.println("sql-------->" + sql);
        System.out.println("受影响行数--->：" + rows);
        return rows;
    }

    /**
     * 获取一个代理对象
     *
     * @return
     */
    public static <T> T getProxy(Class<T> tClass) {
        InsertProxy insertProxy = new InsertProxy();
        return (T) Proxy.newProxyInstance(insertProxy.getClass().getClassLoader(),
                new Class[]{tClass}, insertProxy);
    }
}
