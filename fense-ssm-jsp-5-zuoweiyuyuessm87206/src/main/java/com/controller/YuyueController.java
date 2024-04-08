package com.controller;

import com.entity.*;
import com.service.*;
import com.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName YuyueController
 * @Description 预约模块控制层
 */
@Controller
public class YuyueController extends BaseController{

    @Autowired
    private YuyueService yuyueService;

    @Autowired
    private ZuoweiService zuoweiService;
    @Autowired
    private ShiduanService shiduanService;
    @Autowired
    private UsersService usersService;



    //前台-预约列表页
    @RequestMapping("/yuyueManaQian")
    public ModelAndView yuyueManaQian(Yuyue req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("yuyueManaQian");
        mav.addObject("actionName","yuyueManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-预约图片列表页
    @RequestMapping("/yuyueManaQiantp")
    public ModelAndView yuyueManaQiantp(Yuyue req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("yuyueManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-预约管理列表页
    @RequestMapping("/yuyueMana")
    public ModelAndView yuyueMana(Yuyue req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("yuyueMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-预约查看列表页
    @RequestMapping("/yuyueChakan")
    public ModelAndView yuyueChakan(Yuyue req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("yuyueChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-预约按id列排序列表页
    @RequestMapping("/yuyueManaQianSort")
    public ModelAndView yuyueManaQianSort(Yuyue  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("yuyueManaQian");
        mav.addObject("actionName","yuyueManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-预约详情页
    @GetMapping("/yuyueDetailQian/{id}")
    @ResponseBody
    public ModelAndView yuyueDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("yuyueDetailQian");
        Yuyue info= yuyueService.findById(id);
        mav.addObject("yuyue", info);

        return mav;
    }

    //后台-预约详情页
    @GetMapping("/yuyueDetail/{id}")
    @ResponseBody
    public ModelAndView yuyueDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("yuyueDetail");
        Yuyue info= yuyueService.findById(id);
        mav.addObject("yuyue", info);
        return mav;
    }

    //获取所有预约数据接口
    @RequestMapping("/yuyueAll")
    @ResponseBody
    public ApiResponse<Yuyue> yuyueAll(){
        List<Yuyue> yuyueList=yuyueService.findAll();
        return ApiResponse.success(yuyueList);
    }

    //根据条件（字符类型模糊匹配查询）获取预约数据接口
    @RequestMapping("/yuyueSearch")
    @ResponseBody
    public ApiResponse<Yuyue> yuyueSearch(Yuyue req){
        List<Yuyue> yuyueList=yuyueService.find(req);
        return ApiResponse.success(yuyueList);
    }

    //根据条件（字符类型完全匹配查询）获取预约数据接口
    @RequestMapping("/yuyueSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Yuyue> yuyueSearchByEqualTo(Yuyue req){
        List<Yuyue> yuyueList=yuyueService.findByEqualTo(req);
        return ApiResponse.success(yuyueList);
    }

    //预约添加或修改接口
    @PostMapping("/yuyueAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> yuyueAddOrUpdate(@RequestBody Yuyue req, HttpSession session, Boolean isUPdateSession){



        int result = yuyueService.saveOrUpdate(req);


        return ApiResponse.success(result);
    }

    //预约修改单独一个字段接口
    @PostMapping("/yuyueSet")
    @ResponseBody
    public ApiResponse<Integer> yuyueSet(Yuyue req){
        int result = yuyueService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //预约删除接口
    @RequestMapping("/yuyueDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> yuyueDel(@PathVariable Integer id){
        int result = yuyueService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-预约修改页
    @RequestMapping("/yuyueGet/{id}")
    @ResponseBody
    public ModelAndView yuyueGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("yuyueSet");
        Yuyue info = yuyueService.findById(id);
        mav.addObject("yuyue", info);
        return mav;
    }



    //后台-我的预约查看页面
    @RequestMapping("/yuyueChakanMy")
    public ModelAndView yuyueChakanMy(Yuyue req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("yuyueChakanMy");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }

    //后台-我的预约管理列表页面
    @RequestMapping("/yuyueManaMy")
    public ModelAndView yuyueManaMy(Yuyue req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("yuyueManaMy");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }

    //前台-我的预约管理列表页面
    @RequestMapping("/yuyueManaMyQian")
    public ModelAndView yuyueManaMyQian(Yuyue req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("yuyueManaMyQian");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }


    //前台-座位添加预约页面
    @GetMapping("/zuoweiyuyueAddQian/{zuoweiid}")
    @ResponseBody
    public ModelAndView zuoweiyuyueAddQian(@PathVariable Integer zuoweiid){
        ModelAndView mav = getZuoweiYuyueAddModelAndView(zuoweiid,"zuoweiyuyueAddQian");
        return mav;
    }

    //后台-座位添加预约页面
    @GetMapping("/zuoweiyuyueAdd/{zuoweiid}")
    @ResponseBody
    public ModelAndView zuoweiyuyueAdd(@PathVariable Integer zuoweiid){
        ModelAndView mav = getZuoweiYuyueAddModelAndView(zuoweiid,"zuoweiyuyueAdd");
        return mav;
    }

    //后台-座位预约查看页面
    @RequestMapping("/zuoweiyuyueGetByzuoweiid/{zuoweiid}")
    @ResponseBody
    public ModelAndView zuoweiyuyueGetByzuoweiid(Yuyue req, @PathVariable Integer zuoweiid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("zuoweiyuyueChakan");
        req.setZuoweiid(zuoweiid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-座位预约查看页面
    @RequestMapping("/zuoweiyuyueGetByzuoweiidQian/{zuoweiid}")
    @ResponseBody
    public ModelAndView zuoweiyuyueGetByzuoweiidQian(Yuyue req, @PathVariable Integer zuoweiid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("yuyueManaQian");
            mav.addObject("actionName","yuyueManaQian");
        req.setZuoweiid(zuoweiid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //座位预约数据封装
    private ModelAndView getZuoweiYuyueAddModelAndView(Integer zuoweiid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Zuowei zuowei=zuoweiService.findById(zuoweiid);
        mav.addObject("zuowei", zuowei);
        List<Shiduan> shiduanList=shiduanService.findAll();
        mav.addObject("shiduanList", shiduanList);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
    }
    //前台-时段添加预约页面
    @GetMapping("/shiduanyuyueAddQian/{shiduanid}")
    @ResponseBody
    public ModelAndView shiduanyuyueAddQian(@PathVariable Integer shiduanid){
        ModelAndView mav = getShiduanYuyueAddModelAndView(shiduanid,"shiduanyuyueAddQian");
        return mav;
    }

    //后台-时段添加预约页面
    @GetMapping("/shiduanyuyueAdd/{shiduanid}")
    @ResponseBody
    public ModelAndView shiduanyuyueAdd(@PathVariable Integer shiduanid){
        ModelAndView mav = getShiduanYuyueAddModelAndView(shiduanid,"shiduanyuyueAdd");
        return mav;
    }

    //后台-时段预约查看页面
    @RequestMapping("/shiduanyuyueGetByshiduanid/{shiduanid}")
    @ResponseBody
    public ModelAndView shiduanyuyueGetByshiduanid(Yuyue req, @PathVariable Integer shiduanid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("shiduanyuyueChakan");
        req.setShiduanid(shiduanid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-时段预约查看页面
    @RequestMapping("/shiduanyuyueGetByshiduanidQian/{shiduanid}")
    @ResponseBody
    public ModelAndView shiduanyuyueGetByshiduanidQian(Yuyue req, @PathVariable Integer shiduanid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("yuyueManaQian");
            mav.addObject("actionName","yuyueManaQian");
        req.setShiduanid(shiduanid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //时段预约数据封装
    private ModelAndView getShiduanYuyueAddModelAndView(Integer shiduanid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Shiduan shiduan=shiduanService.findById(shiduanid);
        mav.addObject("shiduan", shiduan);
        List<Zuowei> zuoweiList=zuoweiService.findAll();
        mav.addObject("zuoweiList", zuoweiList);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
    }
    //前台-用户添加预约页面
    @GetMapping("/usersyuyueAddQian/{usersid}")
    @ResponseBody
    public ModelAndView usersyuyueAddQian(@PathVariable Integer usersid){
        ModelAndView mav = getUsersYuyueAddModelAndView(usersid,"usersyuyueAddQian");
        return mav;
    }

    //后台-用户添加预约页面
    @GetMapping("/usersyuyueAdd/{usersid}")
    @ResponseBody
    public ModelAndView usersyuyueAdd(@PathVariable Integer usersid){
        ModelAndView mav = getUsersYuyueAddModelAndView(usersid,"usersyuyueAdd");
        return mav;
    }

    //后台-用户预约查看页面
    @RequestMapping("/usersyuyueGetByusersid/{usersid}")
    @ResponseBody
    public ModelAndView usersyuyueGetByusersid(Yuyue req, @PathVariable Integer usersid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("usersyuyueChakan");
        req.setUsersid(usersid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-用户预约查看页面
    @RequestMapping("/usersyuyueGetByusersidQian/{usersid}")
    @ResponseBody
    public ModelAndView usersyuyueGetByusersidQian(Yuyue req, @PathVariable Integer usersid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("yuyueManaQian");
            mav.addObject("actionName","yuyueManaQian");
        req.setUsersid(usersid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //用户预约数据封装
    private ModelAndView getUsersYuyueAddModelAndView(Integer usersid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Users users=usersService.findById(usersid);
        mav.addObject("users", users);
        List<Zuowei> zuoweiList=zuoweiService.findAll();
        mav.addObject("zuoweiList", zuoweiList);
        List<Shiduan> shiduanList=shiduanService.findAll();
        mav.addObject("shiduanList", shiduanList);

        return mav;
    }



    //预约模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Yuyue req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Yuyue> pageWrap=new PageWrap<Yuyue>();
        pageWrap.setModel(req);
        pageWrap.setPageNum(pageNo);
        //设置每页最多几条数据，默认为8条
        //pageWrap.setPageSize(8);
        PageWrap.SortData sortData=new PageWrap.SortData();
        sortData.setDirection("DESC");
        sortData.setProperty(sortProperty);
        List<PageWrap.SortData> sorts = new ArrayList<>();
        sorts.add(sortData);
        pageWrap.setSorts(sorts);
        PageData<Yuyue> pageInfo= yuyueService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Zuowei> zuoweiList=zuoweiService.findAll();
        mav.addObject("zuoweiList", zuoweiList);
        List<Shiduan> shiduanList=shiduanService.findAll();
        mav.addObject("shiduanList", shiduanList);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
    }

    //预约完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Yuyue req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Yuyue> pageWrap=new PageWrap<Yuyue>();
        pageWrap.setModel(req);
        pageWrap.setPageNum(pageNo);
        //设置每页最多几条数据，默认为8条
        //pageWrap.setPageSize(8);
        PageWrap.SortData sortData=new PageWrap.SortData();
        sortData.setDirection("DESC");
        sortData.setProperty(sortProperty);
        List<PageWrap.SortData> sorts = new ArrayList<>();
        sorts.add(sortData);
        pageWrap.setSorts(sorts);
        PageData<Yuyue> pageInfo= yuyueService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Zuowei> zuoweiList=zuoweiService.findAll();
        mav.addObject("zuoweiList", zuoweiList);
        List<Shiduan> shiduanList=shiduanService.findAll();
        mav.addObject("shiduanList", shiduanList);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
        }
}
