package com.controller;

import com.util.ApiResponse;
import com.util.CaptchaUtil;
import com.util.Md5Util;
import com.entity.Users;
import com.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * @ClassName LoginController
 * @Description 用户登陆
 */
@RestController
public class LoginController extends BaseController {

    @Autowired
    private UsersService usersService;

    //随机验证码
    @GetMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        //设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");

        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        try {
            HttpSession session = request.getSession();
            Object[] verify = CaptchaUtil.newBuilder().build().createImage();

            //将生成的随机字符串保存到session中
            session.removeAttribute("rand");
            session.setAttribute("rand", verify[0]);
            BufferedImage image = (BufferedImage) verify[1];
            ImageIO.write(image, "JPEG", response.getOutputStream());
        } catch (Exception ex) {

        }
    }

    //登陆验证
    @PostMapping("/login")
    @ResponseBody
    public ApiResponse verify(HttpServletRequest request, String captcha, String loginpw, String type, String loginname) {
        String result = "";
        HttpSession session = request.getSession();
        if (null != captcha && !captcha.equals("")) {
            //获取session对象中存储的验证码
            String rand = (String) session.getAttribute("rand");
            if (captcha.equals(rand.trim()) == false) {
                //返回验证码错误
                result = "验证码输入错误";
                return ApiResponse.failed(result);
            }
        }
        Users users = new Users();
        users.setLoginname(loginname);
        users.setLoginpw(Md5Util.strToMd5(loginpw));
        if (null != type && !type.equals("")) {
            users.setType(type);
        }
        users = usersService.findOneByEqualTo(users);

        if (null == users || null == users.getId() || users.getId() == 0) {
            //返回登录失败
            result = "用户名或密码错误";
            return ApiResponse.failed(result);
        } else {
            //返回登录成功
            session.setAttribute("userType", users.getType());
            session.setAttribute("user", users);
            session.setMaxInactiveInterval(-1);
            System.out.println("userType" + users.getType());
            return ApiResponse.success(null);
        }
    }
}
