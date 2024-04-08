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
 * @ClassName LizuoController
 * @Description 离座模块控制层
 */
@Controller
public class LizuoController extends BaseController{

    @Autowired
    private LizuoService lizuoService;

    @Autowired
    private ZuoweiService zuoweiService;
    @Autowired
    private UsersService usersService;



    //前台-离座列表页
    @RequestMapping("/lizuoManaQian")
    public ModelAndView lizuoManaQian(Lizuo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lizuoManaQian");
        mav.addObject("actionName","lizuoManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-离座图片列表页
    @RequestMapping("/lizuoManaQiantp")
    public ModelAndView lizuoManaQiantp(Lizuo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lizuoManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-离座管理列表页
    @RequestMapping("/lizuoMana")
    public ModelAndView lizuoMana(Lizuo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lizuoMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-离座查看列表页
    @RequestMapping("/lizuoChakan")
    public ModelAndView lizuoChakan(Lizuo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lizuoChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-离座按id列排序列表页
    @RequestMapping("/lizuoManaQianSort")
    public ModelAndView lizuoManaQianSort(Lizuo  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("lizuoManaQian");
        mav.addObject("actionName","lizuoManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-离座详情页
    @GetMapping("/lizuoDetailQian/{id}")
    @ResponseBody
    public ModelAndView lizuoDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("lizuoDetailQian");
        Lizuo info= lizuoService.findById(id);
        mav.addObject("lizuo", info);

        return mav;
    }

    //后台-离座详情页
    @GetMapping("/lizuoDetail/{id}")
    @ResponseBody
    public ModelAndView lizuoDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("lizuoDetail");
        Lizuo info= lizuoService.findById(id);
        mav.addObject("lizuo", info);
        return mav;
    }

    //获取所有离座数据接口
    @RequestMapping("/lizuoAll")
    @ResponseBody
    public ApiResponse<Lizuo> lizuoAll(){
        List<Lizuo> lizuoList=lizuoService.findAll();
        return ApiResponse.success(lizuoList);
    }

    //根据条件（字符类型模糊匹配查询）获取离座数据接口
    @RequestMapping("/lizuoSearch")
    @ResponseBody
    public ApiResponse<Lizuo> lizuoSearch(Lizuo req){
        List<Lizuo> lizuoList=lizuoService.find(req);
        return ApiResponse.success(lizuoList);
    }

    //根据条件（字符类型完全匹配查询）获取离座数据接口
    @RequestMapping("/lizuoSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Lizuo> lizuoSearchByEqualTo(Lizuo req){
        List<Lizuo> lizuoList=lizuoService.findByEqualTo(req);
        return ApiResponse.success(lizuoList);
    }

    //离座添加或修改接口
    @PostMapping("/lizuoAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> lizuoAddOrUpdate(@RequestBody Lizuo req, HttpSession session, Boolean isUPdateSession){



        int result = lizuoService.saveOrUpdate(req);


        return ApiResponse.success(result);
    }

    //离座修改单独一个字段接口
    @PostMapping("/lizuoSet")
    @ResponseBody
    public ApiResponse<Integer> lizuoSet(Lizuo req){
        int result = lizuoService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //离座删除接口
    @RequestMapping("/lizuoDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> lizuoDel(@PathVariable Integer id){
        int result = lizuoService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-离座修改页
    @RequestMapping("/lizuoGet/{id}")
    @ResponseBody
    public ModelAndView lizuoGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("lizuoSet");
        Lizuo info = lizuoService.findById(id);
        mav.addObject("lizuo", info);
        return mav;
    }



    //后台-我的离座查看页面
    @RequestMapping("/lizuoChakanMy")
    public ModelAndView lizuoChakanMy(Lizuo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("lizuoChakanMy");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersslid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }

    //后台-我的离座管理列表页面
    @RequestMapping("/lizuoManaMy")
    public ModelAndView lizuoManaMy(Lizuo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("lizuoManaMy");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersslid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }

    //前台-我的离座管理列表页面
    @RequestMapping("/lizuoManaMyQian")
    public ModelAndView lizuoManaMyQian(Lizuo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("lizuoManaMyQian");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersslid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }


    //前台-座位添加离座页面
    @GetMapping("/zuoweilizuoAddQian/{zuoweiid}")
    @ResponseBody
    public ModelAndView zuoweilizuoAddQian(@PathVariable Integer zuoweiid){
        ModelAndView mav = getZuoweiLizuoAddModelAndView(zuoweiid,"zuoweilizuoAddQian");
        return mav;
    }

    //后台-座位添加离座页面
    @GetMapping("/zuoweilizuoAdd/{zuoweiid}")
    @ResponseBody
    public ModelAndView zuoweilizuoAdd(@PathVariable Integer zuoweiid){
        ModelAndView mav = getZuoweiLizuoAddModelAndView(zuoweiid,"zuoweilizuoAdd");
        return mav;
    }

    //后台-座位离座查看页面
    @RequestMapping("/zuoweilizuoGetByzuoweiid/{zuoweiid}")
    @ResponseBody
    public ModelAndView zuoweilizuoGetByzuoweiid(Lizuo req, @PathVariable Integer zuoweiid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("zuoweilizuoChakan");
        req.setZuoweiid(zuoweiid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-座位离座查看页面
    @RequestMapping("/zuoweilizuoGetByzuoweiidQian/{zuoweiid}")
    @ResponseBody
    public ModelAndView zuoweilizuoGetByzuoweiidQian(Lizuo req, @PathVariable Integer zuoweiid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lizuoManaQian");
            mav.addObject("actionName","lizuoManaQian");
        req.setZuoweiid(zuoweiid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //座位离座数据封装
    private ModelAndView getZuoweiLizuoAddModelAndView(Integer zuoweiid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Zuowei zuowei=zuoweiService.findById(zuoweiid);
        mav.addObject("zuowei", zuowei);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
    }
    //前台-用户添加离座页面
    @GetMapping("/userslizuoAddQian/{usersslid}")
    @ResponseBody
    public ModelAndView userslizuoAddQian(@PathVariable Integer usersslid){
        ModelAndView mav = getUsersLizuoAddModelAndView(usersslid,"userslizuoAddQian");
        return mav;
    }

    //后台-用户添加离座页面
    @GetMapping("/userslizuoAdd/{usersslid}")
    @ResponseBody
    public ModelAndView userslizuoAdd(@PathVariable Integer usersslid){
        ModelAndView mav = getUsersLizuoAddModelAndView(usersslid,"userslizuoAdd");
        return mav;
    }

    //后台-用户离座查看页面
    @RequestMapping("/userslizuoGetByusersslid/{usersslid}")
    @ResponseBody
    public ModelAndView userslizuoGetByusersslid(Lizuo req, @PathVariable Integer usersslid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("userslizuoChakan");
        req.setUsersslid(usersslid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-用户离座查看页面
    @RequestMapping("/userslizuoGetByusersslidQian/{usersslid}")
    @ResponseBody
    public ModelAndView userslizuoGetByusersslidQian(Lizuo req, @PathVariable Integer usersslid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lizuoManaQian");
            mav.addObject("actionName","lizuoManaQian");
        req.setUsersslid(usersslid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //用户离座数据封装
    private ModelAndView getUsersLizuoAddModelAndView(Integer usersslid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Users users=usersService.findById(usersslid);
        mav.addObject("users", users);
        List<Zuowei> zuoweiList=zuoweiService.findAll();
        mav.addObject("zuoweiList", zuoweiList);

        return mav;
    }



    //离座模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Lizuo req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Lizuo> pageWrap=new PageWrap<Lizuo>();
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
        PageData<Lizuo> pageInfo= lizuoService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Zuowei> zuoweiList=zuoweiService.findAll();
        mav.addObject("zuoweiList", zuoweiList);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
    }

    //离座完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Lizuo req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Lizuo> pageWrap=new PageWrap<Lizuo>();
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
        PageData<Lizuo> pageInfo= lizuoService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Zuowei> zuoweiList=zuoweiService.findAll();
        mav.addObject("zuoweiList", zuoweiList);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
        }
}
