package cn.jinronga.jdbc.utils;

/**
 * @ClassName DBUtil
 * @Author guojinrong
 * @Date 2020/12/30 14:51
 * @Description DBUtil
 * @Version 1.0
 */

import java.sql.*;

/**
 * 数据库连接工具类
 */
public class DBUtil {
    public static Connection getConnection() {
        String url = "jdbc:sqlserver://192.168.112.115:1433;DatabaseName=test";
        String user = "sa";
        String password = "123456";
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Connection conn = null;
        try {
            Class clazz = Class.forName(driverName);
            Driver driver = (Driver) clazz.newInstance();
//3.注册驱动
            DriverManager.registerDriver(driver);
//4.获取连接
            conn = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeAll(Connection connection, Statement statement, ResultSet
            rs) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
