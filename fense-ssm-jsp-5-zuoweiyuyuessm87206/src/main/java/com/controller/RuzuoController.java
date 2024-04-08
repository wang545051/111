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
 * @ClassName RuzuoController
 * @Description 入座模块控制层
 */
@Controller
public class RuzuoController extends BaseController{

    @Autowired
    private RuzuoService ruzuoService;

    @Autowired
    private ZuoweiService zuoweiService;
    @Autowired
    private UsersService usersService;



    //前台-入座列表页
    @RequestMapping("/ruzuoManaQian")
    public ModelAndView ruzuoManaQian(Ruzuo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("ruzuoManaQian");
        mav.addObject("actionName","ruzuoManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-入座图片列表页
    @RequestMapping("/ruzuoManaQiantp")
    public ModelAndView ruzuoManaQiantp(Ruzuo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("ruzuoManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-入座管理列表页
    @RequestMapping("/ruzuoMana")
    public ModelAndView ruzuoMana(Ruzuo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("ruzuoMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-入座查看列表页
    @RequestMapping("/ruzuoChakan")
    public ModelAndView ruzuoChakan(Ruzuo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("ruzuoChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-入座按id列排序列表页
    @RequestMapping("/ruzuoManaQianSort")
    public ModelAndView ruzuoManaQianSort(Ruzuo  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("ruzuoManaQian");
        mav.addObject("actionName","ruzuoManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-入座详情页
    @GetMapping("/ruzuoDetailQian/{id}")
    @ResponseBody
    public ModelAndView ruzuoDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("ruzuoDetailQian");
        Ruzuo info= ruzuoService.findById(id);
        mav.addObject("ruzuo", info);

        return mav;
    }

    //后台-入座详情页
    @GetMapping("/ruzuoDetail/{id}")
    @ResponseBody
    public ModelAndView ruzuoDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("ruzuoDetail");
        Ruzuo info= ruzuoService.findById(id);
        mav.addObject("ruzuo", info);
        return mav;
    }

    //获取所有入座数据接口
    @RequestMapping("/ruzuoAll")
    @ResponseBody
    public ApiResponse<Ruzuo> ruzuoAll(){
        List<Ruzuo> ruzuoList=ruzuoService.findAll();
        return ApiResponse.success(ruzuoList);
    }

    //根据条件（字符类型模糊匹配查询）获取入座数据接口
    @RequestMapping("/ruzuoSearch")
    @ResponseBody
    public ApiResponse<Ruzuo> ruzuoSearch(Ruzuo req){
        List<Ruzuo> ruzuoList=ruzuoService.find(req);
        return ApiResponse.success(ruzuoList);
    }

    //根据条件（字符类型完全匹配查询）获取入座数据接口
    @RequestMapping("/ruzuoSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Ruzuo> ruzuoSearchByEqualTo(Ruzuo req){
        List<Ruzuo> ruzuoList=ruzuoService.findByEqualTo(req);
        return ApiResponse.success(ruzuoList);
    }

    //入座添加或修改接口
    @PostMapping("/ruzuoAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> ruzuoAddOrUpdate(@RequestBody Ruzuo req, HttpSession session, Boolean isUPdateSession){



        int result = ruzuoService.saveOrUpdate(req);


        return ApiResponse.success(result);
    }

    //入座修改单独一个字段接口
    @PostMapping("/ruzuoSet")
    @ResponseBody
    public ApiResponse<Integer> ruzuoSet(Ruzuo req){
        int result = ruzuoService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //入座删除接口
    @RequestMapping("/ruzuoDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> ruzuoDel(@PathVariable Integer id){
        int result = ruzuoService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-入座修改页
    @RequestMapping("/ruzuoGet/{id}")
    @ResponseBody
    public ModelAndView ruzuoGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("ruzuoSet");
        Ruzuo info = ruzuoService.findById(id);
        mav.addObject("ruzuo", info);
        return mav;
    }



    //后台-我的入座查看页面
    @RequestMapping("/ruzuoChakanMy")
    public ModelAndView ruzuoChakanMy(Ruzuo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("ruzuoChakanMy");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersslid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }

    //后台-我的入座管理列表页面
    @RequestMapping("/ruzuoManaMy")
    public ModelAndView ruzuoManaMy(Ruzuo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("ruzuoManaMy");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersslid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }

    //前台-我的入座管理列表页面
    @RequestMapping("/ruzuoManaMyQian")
    public ModelAndView ruzuoManaMyQian(Ruzuo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("ruzuoManaMyQian");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersslid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }


    //前台-座位添加入座页面
    @GetMapping("/zuoweiruzuoAddQian/{zuoweiid}")
    @ResponseBody
    public ModelAndView zuoweiruzuoAddQian(@PathVariable Integer zuoweiid){
        ModelAndView mav = getZuoweiRuzuoAddModelAndView(zuoweiid,"zuoweiruzuoAddQian");
        return mav;
    }

    //后台-座位添加入座页面
    @GetMapping("/zuoweiruzuoAdd/{zuoweiid}")
    @ResponseBody
    public ModelAndView zuoweiruzuoAdd(@PathVariable Integer zuoweiid){
        ModelAndView mav = getZuoweiRuzuoAddModelAndView(zuoweiid,"zuoweiruzuoAdd");
        return mav;
    }

    //后台-座位入座查看页面
    @RequestMapping("/zuoweiruzuoGetByzuoweiid/{zuoweiid}")
    @ResponseBody
    public ModelAndView zuoweiruzuoGetByzuoweiid(Ruzuo req, @PathVariable Integer zuoweiid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("zuoweiruzuoChakan");
        req.setZuoweiid(zuoweiid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-座位入座查看页面
    @RequestMapping("/zuoweiruzuoGetByzuoweiidQian/{zuoweiid}")
    @ResponseBody
    public ModelAndView zuoweiruzuoGetByzuoweiidQian(Ruzuo req, @PathVariable Integer zuoweiid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("ruzuoManaQian");
            mav.addObject("actionName","ruzuoManaQian");
        req.setZuoweiid(zuoweiid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //座位入座数据封装
    private ModelAndView getZuoweiRuzuoAddModelAndView(Integer zuoweiid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Zuowei zuowei=zuoweiService.findById(zuoweiid);
        mav.addObject("zuowei", zuowei);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
    }
    //前台-用户添加入座页面
    @GetMapping("/usersruzuoAddQian/{usersslid}")
    @ResponseBody
    public ModelAndView usersruzuoAddQian(@PathVariable Integer usersslid){
        ModelAndView mav = getUsersRuzuoAddModelAndView(usersslid,"usersruzuoAddQian");
        return mav;
    }

    //后台-用户添加入座页面
    @GetMapping("/usersruzuoAdd/{usersslid}")
    @ResponseBody
    public ModelAndView usersruzuoAdd(@PathVariable Integer usersslid){
        ModelAndView mav = getUsersRuzuoAddModelAndView(usersslid,"usersruzuoAdd");
        return mav;
    }

    //后台-用户入座查看页面
    @RequestMapping("/usersruzuoGetByusersslid/{usersslid}")
    @ResponseBody
    public ModelAndView usersruzuoGetByusersslid(Ruzuo req, @PathVariable Integer usersslid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("usersruzuoChakan");
        req.setUsersslid(usersslid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-用户入座查看页面
    @RequestMapping("/usersruzuoGetByusersslidQian/{usersslid}")
    @ResponseBody
    public ModelAndView usersruzuoGetByusersslidQian(Ruzuo req, @PathVariable Integer usersslid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("ruzuoManaQian");
            mav.addObject("actionName","ruzuoManaQian");
        req.setUsersslid(usersslid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //用户入座数据封装
    private ModelAndView getUsersRuzuoAddModelAndView(Integer usersslid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Users users=usersService.findById(usersslid);
        mav.addObject("users", users);
        List<Zuowei> zuoweiList=zuoweiService.findAll();
        mav.addObject("zuoweiList", zuoweiList);

        return mav;
    }



    //入座模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Ruzuo req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Ruzuo> pageWrap=new PageWrap<Ruzuo>();
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
        PageData<Ruzuo> pageInfo= ruzuoService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Zuowei> zuoweiList=zuoweiService.findAll();
        mav.addObject("zuoweiList", zuoweiList);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
    }

    //入座完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Ruzuo req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Ruzuo> pageWrap=new PageWrap<Ruzuo>();
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
        PageData<Ruzuo> pageInfo= ruzuoService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Zuowei> zuoweiList=zuoweiService.findAll();
        mav.addObject("zuoweiList", zuoweiList);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
        }
}
