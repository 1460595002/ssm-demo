package cn.jinronga.agency.staticProxy;

import cn.jinronga.agency.MaleSinger;

/**
 * @ClassName Client
 * @Author guojinrong
 * @Date 2020/12/30 11:37
 * @Description Client
 * @Version 1.0
 */
//客户
public class Client {
    public static void main(String[] args) {
        MaleSinger singer = new MaleSinger("周杰伦");
        //经济人
        Agent agent = new Agent(singer);
        agent.sing();
    }
}
