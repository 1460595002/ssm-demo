package cn.jinronga.test.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName R
 * @Author guojinrong
 * @Date 2020/12/29 16:26
 * @Description R
 * @Version 1.0
 * 统一返回工具类
 */
@Data
public class R implements Serializable {
    private int code;
    private String msg;
    private Map<String,Object> data;
    private R(int code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    //成功的返回
    public static R success(){
        return new R(200,"操作成功",null);
    }
    //失败的返回
    public static R fail(){
        return new R(500,"操作失败",null);
    }
    //其他类型的返回
    public static R build(int code,String msg){
        return new R(500,msg,null);
    }
    public R put(String key,Object msg){
        if(this.getData() == null){
            this.setData(new HashMap<>(16));
        }
        this.getData().put(key,msg);
        return this;
    }
}
