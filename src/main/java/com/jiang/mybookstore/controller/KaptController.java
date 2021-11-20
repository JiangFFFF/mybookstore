package com.jiang.mybookstore.controller;

import com.baomidou.kaptcha.Kaptcha;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 直接使用生成验证码
 * @author jiang
 * @create 2021-11-19-3:35 下午
 */
@Controller
public class KaptController {

    //注入生成验证码所需要的Producer对象
    @Autowired
    private Producer kaptcha;

    /**
     * 获取验证码
     */
    @RequestMapping("/kaptcha")
    public void getKpthcha(HttpServletResponse response, HttpSession session){
        //生成验证码内容
        String text = kaptcha.createText();
        //生成验证码图片
        BufferedImage image = kaptcha.createImage(text);
        //将文字保存进session中
        session.setAttribute("code",text);
        //将图片写回流中,输出给浏览器
        response.setContentType("image/png");
        try {
            ServletOutputStream os = response.getOutputStream();
            ImageIO.write(image,"png",os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
