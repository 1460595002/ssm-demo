package cn.jinronga.test.contorller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 配置版SpringMCV
 */
public class FirstController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        //ModelAndView 封装了模型和视图
        ModelAndView mv = new ModelAndView();
        //模型里封装数据
        mv.addObject("hellomvc", "Hello springMVC!");
        //封装跳转的视图
        mv.setViewName("hellomvc");
        //就是刚刚配置的试图解析器成果
        //这玩意就是为了省事的，自动给你加个前缀后缀
        //就成了 /jsp/hellomvc.jsp ---拼串
        return mv;
    }
}