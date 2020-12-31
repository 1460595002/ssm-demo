package cn.jinronga.agency.dynamicProxy;

import cn.jinronga.agency.Singer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName Agent1
 * @Author guojinrong
 * @Date 2020/12/30 14:13
 * @Description Agent1
 * @Version 1.0
 */
public class Agent1 implements InvocationHandler {
    private Singer singer;

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----经纪人把把关-----------");
        /**
         * 设置代理对象
         */
        Object invoke = method.invoke(singer, args);
        System.out.println("----演出完收钱！！-----------");
        return invoke;
    }

    /**
     * 获取一个代理类对象
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{Singer.class},this);
    }
}
