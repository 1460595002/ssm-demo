package cn.jinronga.agency;

/**
 * @ClassName MaleSinger
 * @Author guojinrong
 * @Date 2020/12/30 11:30
 * @Description MaleSinger
 * @Version 1.0
 */
//歌手
public class MaleSinger implements Singer {
    private String name;

    public MaleSinger() {

    }

    public MaleSinger(String name) {
        this.name = name;
    }

    @Override
    public void sing() {
        System.out.println(name + "开始唱歌");
    }
}
