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

import com.entity.DingdanEntity;

import com.service.DingdanService;
import com.entity.view.DingdanView;
import com.service.DipiOrderService;
import com.entity.DipiOrderEntity;
import com.service.KehuService;
import com.entity.KehuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/dingdan")
public class DingdanController {
    private static final Logger logger = LoggerFactory.getLogger(DingdanController.class);

    @Autowired
    private DingdanService dingdanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private DipiOrderService dipiOrderService;
    @Autowired
    private KehuService kehuService;


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
        PageUtils page = dingdanService.queryPage(params);

        //字典表数据转换
        List<DingdanView> list =(List<DingdanView>)page.getList();
        for(DingdanView c:list){
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
        DingdanEntity dingdan = dingdanService.selectById(id);
        if(dingdan !=null){
            //entity转view
            DingdanView view = new DingdanView();
            BeanUtils.copyProperties( dingdan , view );//把实体数据重构到view中

            //级联表
            DipiOrderEntity dipiOrder = dipiOrderService.selectById(dingdan.getDipiOrderId());
            if(dipiOrder != null){
                BeanUtils.copyProperties( dipiOrder , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setDipiOrderId(dipiOrder.getId());
            }
            //级联表
            KehuEntity kehu = kehuService.selectById(dingdan.getKehuId());
            if(kehu != null){
                BeanUtils.copyProperties( kehu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setKehuId(kehu.getId());
            }
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
    public R save(@RequestBody DingdanEntity dingdan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,dingdan:{}",this.getClass().getName(),dingdan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("客户".equals(role))
            dingdan.setKehuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        Wrapper<DingdanEntity> queryWrapper = new EntityWrapper<DingdanEntity>()
            .eq("dipi_order_id", dingdan.getDipiOrderId())
            .eq("kehu_id", dingdan.getKehuId())
            .eq("dingdan_wupin", dingdan.getDingdanWupin())
            .eq("wupin_number", dingdan.getWupinNumber())
            .eq("xingming", dingdan.getXingming())
            .eq("shouhuoren_phone", dingdan.getShouhuorenPhone())
            .eq("address", dingdan.getAddress())
            .eq("dingdan_danhao_number", dingdan.getDingdanDanhaoNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DingdanEntity dingdanEntity = dingdanService.selectOne(queryWrapper);
        if(dingdanEntity==null){
            dingdan.setInsertTime(new Date());
            dingdan.setCreateTime(new Date());
            dingdanService.insert(dingdan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DingdanEntity dingdan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,dingdan:{}",this.getClass().getName(),dingdan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("客户".equals(role))
            dingdan.setKehuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<DingdanEntity> queryWrapper = new EntityWrapper<DingdanEntity>()
            .notIn("id",dingdan.getId())
            .andNew()
            .eq("dipi_order_id", dingdan.getDipiOrderId())
            .eq("kehu_id", dingdan.getKehuId())
            .eq("dingdan_wupin", dingdan.getDingdanWupin())
            .eq("wupin_number", dingdan.getWupinNumber())
            .eq("xingming", dingdan.getXingming())
            .eq("shouhuoren_phone", dingdan.getShouhuorenPhone())
            .eq("address", dingdan.getAddress())
            .eq("dingdan_danhao_number", dingdan.getDingdanDanhaoNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DingdanEntity dingdanEntity = dingdanService.selectOne(queryWrapper);
        if(dingdanEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      dingdan.set
            //  }
            dingdanService.updateById(dingdan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        dingdanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
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
        PageUtils page = dingdanService.queryPage(params);

        //字典表数据转换
        List<DingdanView> list =(List<DingdanView>)page.getList();
        for(DingdanView c:list)
            dictionaryService.dictionaryConvert(c); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DingdanEntity dingdan = dingdanService.selectById(id);
            if(dingdan !=null){
                //entity转view
                DingdanView view = new DingdanView();
                BeanUtils.copyProperties( dingdan , view );//把实体数据重构到view中

                //级联表
                    DipiOrderEntity dipiOrder = dipiOrderService.selectById(dingdan.getDipiOrderId());
                if(dipiOrder != null){
                    BeanUtils.copyProperties( dipiOrder , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setDipiOrderId(dipiOrder.getId());
                }
                //级联表
                    KehuEntity kehu = kehuService.selectById(dingdan.getKehuId());
                if(kehu != null){
                    BeanUtils.copyProperties( kehu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKehuId(kehu.getId());
                }
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
    public R add(@RequestBody DingdanEntity dingdan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,dingdan:{}",this.getClass().getName(),dingdan.toString());
        Wrapper<DingdanEntity> queryWrapper = new EntityWrapper<DingdanEntity>()
            .eq("dipi_order_id", dingdan.getDipiOrderId())
            .eq("kehu_id", dingdan.getKehuId())
            .eq("dingdan_wupin", dingdan.getDingdanWupin())
            .eq("wupin_number", dingdan.getWupinNumber())
            .eq("xingming", dingdan.getXingming())
            .eq("shouhuoren_phone", dingdan.getShouhuorenPhone())
            .eq("address", dingdan.getAddress())
            .eq("dingdan_danhao_number", dingdan.getDingdanDanhaoNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DingdanEntity dingdanEntity = dingdanService.selectOne(queryWrapper);
        if(dingdanEntity==null){
            dingdan.setInsertTime(new Date());
            dingdan.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      dingdan.set
        //  }
        dingdanService.insert(dingdan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }





}

