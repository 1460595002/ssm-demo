package cn.jinronga.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Admin
 * @Author guojinrong
 * @Date 2020/12/31 10:30
 * @Description Admin
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private int id;
    private String username;
    private String password;
}
