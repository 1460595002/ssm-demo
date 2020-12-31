package cn.jinronga.agency.staticProxy;

import cn.jinronga.agency.Singer;

/**
 * @ClassName Agent
 * @Author guojinrong
 * @Date 2020/12/30 11:32
 * @Description Agent
 * @Version 1.0
 */
//歌手经理人
public class Agent implements Singer {
    private Singer singer;

    public Agent(Singer singer) {
        this.singer = singer;
    }

    @Override
    public void sing() {
        System.out.println("节目组找过来！需要演出，谈好演出费用。。。。。");
        singer.sing();
        System.out.println("结算费用，下一次合作预约。。。。。。");
    }
}
