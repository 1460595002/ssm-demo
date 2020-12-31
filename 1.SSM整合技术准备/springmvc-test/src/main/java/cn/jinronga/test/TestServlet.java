package cn.jinronga.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName TestServlet
 * @Author guojinrong
 * @Date 2020/12/28 14:14
 * @Description TestServlet
 * @Version 1.0
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        resp.getWriter().println("hello servlet!!");
    }
}
