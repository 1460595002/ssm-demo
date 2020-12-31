package cn.jinronga.mybatis.entity;

import lombok.Data;

/**
 * @ClassName Emp
 * @Author guojinrong
 * @Date 2020/12/31 15:23
 * @Description Emp
 * @Version 1.0
 */
@Data
public class Emp {
    private int id;
    private String name;
    //维护关系
    private int did;
}
