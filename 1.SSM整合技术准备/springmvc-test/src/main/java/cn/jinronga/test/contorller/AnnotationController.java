package cn.jinronga.test.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName AnnotationController
 * @Author guojinrong
 * @Date 2020/12/28 16:55
 * @Description AnnotationController
 * @Version 1.0
 * 注解版SpringMvc
 */
@Controller//这是一个控制器
public class AnnotationController {

    /**
     * 方法一
     * @return
     */
    @RequestMapping("/annotation")  //或者@RequestMapping(value = "/annotation", method = RequestMethod.GET)
    public ModelAndView testAnnotation(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hello","我会好好学习Java的");
        //视图
        modelAndView.setViewName("annotation");
        return modelAndView;
    }

    /**
     * 方法二 解偶推荐使用
     */
    @RequestMapping("/test2")
    public String test2Annotation(Model model){
        //添加模型
        model.addAttribute("hello","我会好好学习Java");
        //跳转到annotation视图
        return "annotation";
    }

}
