package com.controller;

import com.entity.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName IndexController
 * @Description 首页控制层
 */
@Controller
public class IndexController extends BaseController {

    @Autowired
    private DxService dxService;
    @Autowired
    private FangjianService fangjianService;
    @Autowired
    private GonggaoService gonggaoService;
    @Autowired
    private LeibieService leibieService;
    @Autowired
    private LianjieService lianjieService;
    @Autowired
    private LiuyanService liuyanService;
    @Autowired
    private LizuoService lizuoService;
    @Autowired
    private LoucengService loucengService;
    @Autowired
    private LunboService lunboService;
    @Autowired
    private RuzuoService ruzuoService;
    @Autowired
    private ShiduanService shiduanService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private YuyueService yuyueService;
    @Autowired
    private ZuoweiService zuoweiService;


    //首页
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("index");
        //取出所有业务表数据存储到session里方便前端页面随意调用
        HttpSession session = request.getSession();

        //介绍表dx
        List<Dx> dxList = dxService.findAll();
        session.setAttribute("dxList", dxList);
        session.setAttribute("dxListSize", dxList.size());
        //房间表fangjian
        List<Fangjian> fangjianList = fangjianService.findAll();
        session.setAttribute("fangjianList", fangjianList);
        session.setAttribute("fangjianListSize", fangjianList.size());
        //公告表gonggao
        List<Gonggao> gonggaoList = gonggaoService.findAll();
        session.setAttribute("gonggaoList", gonggaoList);
        session.setAttribute("gonggaoListSize", gonggaoList.size());
        //类别表leibie
        List<Leibie> leibieList = leibieService.findAll();
        session.setAttribute("leibieList", leibieList);
        session.setAttribute("leibieListSize", leibieList.size());
        //友情链接表lianjie
        List<Lianjie> lianjieList = lianjieService.findAll();
        session.setAttribute("lianjieList", lianjieList);
        session.setAttribute("lianjieListSize", lianjieList.size());
        //留言反馈表liuyan
        List<Liuyan> liuyanList = liuyanService.findAll();
        session.setAttribute("liuyanList", liuyanList);
        session.setAttribute("liuyanListSize", liuyanList.size());
        //离座表lizuo
        List<Lizuo> lizuoList = lizuoService.findAll();
        session.setAttribute("lizuoList", lizuoList);
        session.setAttribute("lizuoListSize", lizuoList.size());
        //楼层表louceng
        List<Louceng> loucengList = loucengService.findAll();
        session.setAttribute("loucengList", loucengList);
        session.setAttribute("loucengListSize", loucengList.size());
        //轮播图表lunbo
        List<Lunbo> lunboList = lunboService.findAll();
        session.setAttribute("lunboList", lunboList);
        session.setAttribute("lunboListSize", lunboList.size());
        //入座表ruzuo
        List<Ruzuo> ruzuoList = ruzuoService.findAll();
        session.setAttribute("ruzuoList", ruzuoList);
        session.setAttribute("ruzuoListSize", ruzuoList.size());
        //时段表shiduan
        List<Shiduan> shiduanList = shiduanService.findAll();
        session.setAttribute("shiduanList", shiduanList);
        session.setAttribute("shiduanListSize", shiduanList.size());
        //用户表users
        List<Users> usersList = usersService.findAll();
        session.setAttribute("usersList", usersList);
        session.setAttribute("usersListSize", usersList.size());
        //预约表yuyue
        List<Yuyue> yuyueList = yuyueService.findAll();
        session.setAttribute("yuyueList", yuyueList);
        session.setAttribute("yuyueListSize", yuyueList.size());
        //座位表zuowei
        List<Zuowei> zuoweiList = zuoweiService.findAll();
        session.setAttribute("zuoweiList", zuoweiList);
        session.setAttribute("zuoweiListSize", zuoweiList.size());

        return mav;
    }
}
