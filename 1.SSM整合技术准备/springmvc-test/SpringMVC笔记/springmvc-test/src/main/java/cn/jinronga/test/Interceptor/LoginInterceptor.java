package cn.jinronga.test.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
/*    *//**
     * 在执行Controller方法前拦截，判断用户是否已经登录，
     * 登录了就放行，还没登录就重定向到登录页面
     *//*
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
//还没登录，重定向到登录页面
            response.sendRedirect("/toLogin");
        }
//已经登录，放行
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse
            response, Object handler, Exception ex) {
    }*/
}