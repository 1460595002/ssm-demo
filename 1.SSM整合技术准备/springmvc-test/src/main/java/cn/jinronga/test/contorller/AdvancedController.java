package cn.jinronga.test.contorller;

import cn.jinronga.test.entity.User;
import cn.jinronga.test.utils.R;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AdvancedController
 * @Author guojinrong
 * @Date 2020/12/28 17:45
 * @Description AdvancedController
 * @Version 1.0
 */
@RequestMapping("user")
@Controller
public class AdvancedController {

    @RequestMapping("login")
    public String login(String username, String password) {
        System.out.println(username);
        System.out.println(password);
        return "hellomvc";
    }

    @PostMapping(value = "/registe")
    public String registe(User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getAge());
        return "hellomvc";
    }

    @RequestMapping(value = "getUsers", produces = {"text/json;charset=utf-8"})
    @ResponseBody
    public String getUsers() {
        ArrayList<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUsername("jinronga");
        user1.setAge(20);
        user1.setPassword("123456@@@");
        User user2 = new User();
        user2.setUsername("jinronga2");
        user2.setAge(20);
        user2.setPassword("456789@@@");
        users.add(user1);
        users.add(user2);
        return JSONArray.toJSONString(users);
    }

    @RequestMapping("getUserList")
    @ResponseBody
    public List<User> getUserList() {
        ArrayList<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUsername("jinronga");
        user1.setAge(20);
        user1.setPassword("123456@@@");
        User user2 = new User();
        user2.setUsername("jinronga2");
        user2.setAge(20);
        user2.setPassword("456789@@@");
        users.add(user1);
        users.add(user2);

        return users;
    }

    /**
     * 文件上传
     */
    @PostMapping("/upload")
    @ResponseBody
    public R upload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest
            request) throws Exception {
//获取文件名 : file.getOriginalFilename();
        String uploadFileName = file.getOriginalFilename();
        System.out.println("上传文件名 : " + uploadFileName);
//上传路径保存设置
        String path = "D:/upload";
//如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址：" + realPath);
//写读流一样
        file.transferTo(new File(path + "/" + uploadFileName));
        return R.success();
    }

    /**
     * 文件下载
     */
    @GetMapping("/download1")
    @ResponseBody
    public R download1(HttpServletResponse response) {

        FileInputStream fileInputStream = null;
        ServletOutputStream outputStream = null;
        try {
//以文件形式下载
            String fileName = "sys-error.log";
//1、设置response 响应头，处理中文名字乱码问题
            response.reset(); //设置页面不缓存,清空buffer
            response.setCharacterEncoding("UTF-8"); //字符编码
            response.setContentType("multipart/form-data"); //二进制传输数据
//设置响应头
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
            File file = new File("D:/upload/" + fileName);
            fileInputStream = new FileInputStream(file);
            outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
                outputStream.flush();
            }
            return R.success();
        } catch (IOException e) {
            e.printStackTrace();
            return R.fail();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @GetMapping("/download2")
    public ResponseEntity<byte[]> download2(){
        try {
            String fileName = "sys-error.log";
            byte[] bytes = FileUtils.readFileToByteArray(new File("D:/upload/"+fileName));
            HttpHeaders headers=new HttpHeaders();
            headers.set("Content-Disposition","attachment;filename="+
                    URLEncoder.encode(fileName, "UTF-8"));
            headers.set("charsetEncoding","utf-8");
            headers.set("content-type","multipart/form-data");
            ResponseEntity<byte[]> entity=new ResponseEntity<>(bytes,headers,
                    HttpStatus.OK);
            return entity;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
