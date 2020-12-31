package cn.jinronga.agency.dynamicProxy;

import cn.jinronga.agency.MaleSinger;
import cn.jinronga.agency.Singer;

/**
 * @ClassName Client
 * @Author guojinrong
 * @Date 2020/12/30 14:21
 * @Description Client
 * @Version 1.0
 */
public class Client1 {
    public static void main(String[] args) {
        MaleSinger maleSinger = new MaleSinger("周杰伦");
        Agent1 agent1 = new Agent1();
        agent1.setSinger(maleSinger);
        Singer singer = (Singer) agent1.getProxy();

        singer.sing();
    }
}
