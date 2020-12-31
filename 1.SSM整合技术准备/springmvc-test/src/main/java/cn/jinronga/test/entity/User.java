package cn.jinronga.test.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @ClassName User
 * @Author guojinrong
 * @Date 2020/12/29 8:52
 * @Description User
 * @Version 1.0
 */
@Data
public class User {
    private int id;
    @NotEmpty(message = "姓名不能为空")
    private String username;

    private String password;
    @Min(value = 0, message = "年龄不能小于{value}")
    @Max(value = 120,message = "年龄不能大于{value}")
    private int age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthday;
    //注意：真正开发不会这样用！！！ BigDecimal使用定义
    @NumberFormat(pattern = "#,###,###.#")
    private Double salary;

    @Pattern(regexp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$", message =
            "手机号码不正确")
    private String phone;

}
