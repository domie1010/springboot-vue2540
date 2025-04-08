package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.KehuEntity;

import com.service.KehuService;
import com.entity.view.KehuView;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 客户
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/kehu")
public class KehuController {
    private static final Logger logger = LoggerFactory.getLogger(KehuController.class);

    @Autowired
    private KehuService kehuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("客户".equals(role))
            params.put("kehuId",request.getSession().getAttribute("userId"));
        params.put("orderBy","id");
        PageUtils page = kehuService.queryPage(params);

        //字典表数据转换
        List<KehuView> list =(List<KehuView>)page.getList();
        for(KehuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        KehuEntity kehu = kehuService.selectById(id);
        if(kehu !=null){
            //entity转view
            KehuView view = new KehuView();
            BeanUtils.copyProperties( kehu , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KehuEntity kehu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,kehu:{}",this.getClass().getName(),kehu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        Wrapper<KehuEntity> queryWrapper = new EntityWrapper<KehuEntity>()
            .eq("username", kehu.getUsername())
            .or()
            .eq("kehu_phone", kehu.getKehuPhone())
            .or()
            .eq("kehu_id_number", kehu.getKehuIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KehuEntity kehuEntity = kehuService.selectOne(queryWrapper);
        if(kehuEntity==null){
            kehu.setCreateTime(new Date());
            kehu.setPassword("123456");
            kehuService.insert(kehu);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KehuEntity kehu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,kehu:{}",this.getClass().getName(),kehu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<KehuEntity> queryWrapper = new EntityWrapper<KehuEntity>()
            .notIn("id",kehu.getId())
            .andNew()
            .eq("username", kehu.getUsername())
            .or()
            .eq("kehu_phone", kehu.getKehuPhone())
            .or()
            .eq("kehu_id_number", kehu.getKehuIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KehuEntity kehuEntity = kehuService.selectOne(queryWrapper);
        if("".equals(kehu.getKehuPhoto()) || "null".equals(kehu.getKehuPhoto())){
                kehu.setKehuPhoto(null);
        }
        if(kehuEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      kehu.set
            //  }
            kehuService.updateById(kehu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        kehuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        KehuEntity kehu = kehuService.selectOne(new EntityWrapper<KehuEntity>().eq("username", username));
        if(kehu==null || !kehu.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(kehu.getId(),username, "kehu", "客户");
        R r = R.ok();
        r.put("token", token);
        r.put("role","客户");
        r.put("username",kehu.getKehuName());
        r.put("tableName","kehu");
        r.put("userId",kehu.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody KehuEntity kehu){
    //    	ValidatorUtils.validateEntity(user);
        if(kehuService.selectOne(new EntityWrapper<KehuEntity>().eq("username", kehu.getUsername()).orNew().eq("kehu_phone",kehu.getKehuPhone()).orNew().eq("kehu_id_number",kehu.getKehuIdNumber())) !=null)
            return R.error("账户已存在或手机号或身份证号已经被使用");
        kehu.setCreateTime(new Date());
        kehuService.insert(kehu);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        KehuEntity kehu = new KehuEntity();
        kehu.setPassword("123456");
        kehu.setId(id);
        kehuService.updateById(kehu);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrKehu(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        KehuEntity kehu = kehuService.selectById(id);
        if(kehu !=null){
            //entity转view
            KehuView view = new KehuView();
            BeanUtils.copyProperties( kehu , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("客户".equals(role))
            params.put("kehuId",request.getSession().getAttribute("userId"));
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = kehuService.queryPage(params);

        //字典表数据转换
        List<KehuView> list =(List<KehuView>)page.getList();
        for(KehuView c:list)
            dictionaryService.dictionaryConvert(c); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        KehuEntity kehu = kehuService.selectById(id);
            if(kehu !=null){
                //entity转view
                KehuView view = new KehuView();
                BeanUtils.copyProperties( kehu , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody KehuEntity kehu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,kehu:{}",this.getClass().getName(),kehu.toString());
        Wrapper<KehuEntity> queryWrapper = new EntityWrapper<KehuEntity>()
            .eq("username", kehu.getUsername())
            .or()
            .eq("kehu_phone", kehu.getKehuPhone())
            .or()
            .eq("kehu_id_number", kehu.getKehuIdNumber());
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KehuEntity kehuEntity = kehuService.selectOne(queryWrapper);
        if(kehuEntity==null){
            kehu.setCreateTime(new Date());
        kehu.setPassword("123456");
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      kehu.set
        //  }
        kehuService.insert(kehu);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }





}

