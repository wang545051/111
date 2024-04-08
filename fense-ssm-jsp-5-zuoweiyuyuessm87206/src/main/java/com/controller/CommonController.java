package com.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @ClassName CommonController
 * @Description 通用方法模块控制层
 */
@Controller
@RequestMapping("/common")
public class CommonController extends BaseController {

    @RequestMapping(value="/upload")
    public ModelAndView upload(String id){
        ModelAndView mav = new ModelAndView("common/upload");
        mav.addObject("id",id);
        return mav;
    }

    /**
     * 文件上传功能
     * @param fujian
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/uploadfile")
    @ResponseBody
    public ModelAndView uploadFile(@RequestParam("fujian") MultipartFile fujian, HttpServletRequest request,String id) throws IOException {
        ModelAndView mav = new ModelAndView("common/upload_re");
        String fujianFileName=fujian.getOriginalFilename();
        String newFujianName=new Date().getTime()+fujianFileName.substring(fujianFileName.indexOf("."));
        String dstPath = request.getSession().getServletContext().getRealPath("upload")+ "\\" + newFujianName;
        File dstFile = new File(dstPath);
        if (!dstFile.getParentFile().exists()) {
            // 如果目标文件所在的目录不存在，则创建父目录
            dstFile.getParentFile().mkdirs();
        }
        // 新文件
        File newFile = new File(dstPath);
        fujian.transferTo(newFile);
        mav.addObject("newFujianName",newFujianName);
        mav.addObject("oldFujianName",fujianFileName);
        mav.addObject("fujianPath","upload"+ "/" + newFujianName);
        mav.addObject("id",id);

        return mav;
    }

    /**
     * 文件下载
     * @throws IOException
     */
    @RequestMapping(value="/download",method=RequestMethod.GET)
    public void download(@RequestParam(value="filename")String filename,
                         HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        filename=filename.replace("upload/","");
        //需要下载的文件
        String path = request.getSession().getServletContext().getRealPath("upload")+ "\\"+filename;
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }
}
