package cn.jinronga.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Student
 * @Author guojinrong
 * @Date 2020/12/30 15:07
 * @Description Student
 * @Version 1.0
 */
@Data
@NoArgsConstructor                 //无参构造
@AllArgsConstructor   //有参构造
public class Student {
    private String id;
    private String name;
    private String sex;
    private int age;
    private String stitute;
}
