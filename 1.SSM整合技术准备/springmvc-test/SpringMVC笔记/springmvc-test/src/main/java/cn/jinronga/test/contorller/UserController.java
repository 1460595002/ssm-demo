package cn.jinronga.test.contorller;

import cn.jinronga.test.entity.User;
import cn.jinronga.test.utils.R;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName UserContorller
 * @Author guojinrong
 * @Date 2020/12/29 11:58
 * @Description UserContorller
 * @Version 1.0
 */
@Controller //@RestController 是@Controller与@ResponseBody结合
public class UserController {

    @PostMapping("/user")
    @ResponseBody
    public User user(@Validated User user) {
        return user;
    }

    @PostMapping("/user1")
    @ResponseBody
    public void testAnnotation(@Validated User user, BindingResult br) {
        List<ObjectError> allErrors = br.getAllErrors();
        for (ObjectError error : allErrors) {
            System.out.println(error.getDefaultMessage());
            System.out.println(error.getCode());
        }
//验证有错误直接返回
        if (allErrors.size() > 0) {
            return;
        }
        System.out.print(user);
    }

    @GetMapping("/rest/{id}")
    @ResponseBody
    public User getUser(@PathVariable int id){
        System.out.println(id);
        //....
        User user = new User();
        user.setUsername("金融啊");
        user.setAge(20);
        user.setId(id);

        return user;
    }
    @DeleteMapping("/rest/{id}")
    @ResponseBody
    public R deleteUser(@PathVariable int id){
        System.out.println(id);
        //....
        return R.success();
    }

    @PostMapping("/rest/{id}")
    @ResponseBody
    public R updateUser(@PathVariable int id,User user){
        System.out.println(id);
        System.out.println(user);
        //...
        return R.fail();
    }
    @PostMapping("/rest/add")
    @ResponseBody
    public R addrUser(User user){
        System.out.println(user);
        return R.build(304,"插入发生异常").put("reason","超时了")
                .put("other","金融融融融果果");
    }
}
