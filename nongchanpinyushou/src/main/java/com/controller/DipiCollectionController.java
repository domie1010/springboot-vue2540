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

import com.entity.DipiCollectionEntity;

import com.service.DipiCollectionService;
import com.entity.view.DipiCollectionView;
import com.service.DipiService;
import com.entity.DipiEntity;
import com.service.KehuService;
import com.entity.KehuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 地皮收藏
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/dipiCollection")
public class DipiCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(DipiCollectionController.class);

    @Autowired
    private DipiCollectionService dipiCollectionService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private DipiService dipiService;
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
        PageUtils page = dipiCollectionService.queryPage(params);

        //字典表数据转换
        List<DipiCollectionView> list =(List<DipiCollectionView>)page.getList();
        for(DipiCollectionView c:list){
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
        DipiCollectionEntity dipiCollection = dipiCollectionService.selectById(id);
        if(dipiCollection !=null){
            //entity转view
            DipiCollectionView view = new DipiCollectionView();
            BeanUtils.copyProperties( dipiCollection , view );//把实体数据重构到view中

            //级联表
            DipiEntity dipi = dipiService.selectById(dipiCollection.getDipiId());
            if(dipi != null){
                BeanUtils.copyProperties( dipi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setDipiId(dipi.getId());
            }
            //级联表
            KehuEntity kehu = kehuService.selectById(dipiCollection.getKehuId());
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
    public R save(@RequestBody DipiCollectionEntity dipiCollection, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,dipiCollection:{}",this.getClass().getName(),dipiCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("客户".equals(role))
            dipiCollection.setKehuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        Wrapper<DipiCollectionEntity> queryWrapper = new EntityWrapper<DipiCollectionEntity>()
            .eq("dipi_id", dipiCollection.getDipiId())
            .eq("kehu_id", dipiCollection.getKehuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DipiCollectionEntity dipiCollectionEntity = dipiCollectionService.selectOne(queryWrapper);
        if(dipiCollectionEntity==null){
            dipiCollection.setInsertTime(new Date());
            dipiCollection.setCreateTime(new Date());
            dipiCollectionService.insert(dipiCollection);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DipiCollectionEntity dipiCollection, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,dipiCollection:{}",this.getClass().getName(),dipiCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("客户".equals(role))
            dipiCollection.setKehuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<DipiCollectionEntity> queryWrapper = new EntityWrapper<DipiCollectionEntity>()
            .notIn("id",dipiCollection.getId())
            .andNew()
            .eq("dipi_id", dipiCollection.getDipiId())
            .eq("kehu_id", dipiCollection.getKehuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DipiCollectionEntity dipiCollectionEntity = dipiCollectionService.selectOne(queryWrapper);
        if(dipiCollectionEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      dipiCollection.set
            //  }
            dipiCollectionService.updateById(dipiCollection);//根据id更新
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
        dipiCollectionService.deleteBatchIds(Arrays.asList(ids));
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
        PageUtils page = dipiCollectionService.queryPage(params);

        //字典表数据转换
        List<DipiCollectionView> list =(List<DipiCollectionView>)page.getList();
        for(DipiCollectionView c:list)
            dictionaryService.dictionaryConvert(c); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DipiCollectionEntity dipiCollection = dipiCollectionService.selectById(id);
            if(dipiCollection !=null){
                //entity转view
                DipiCollectionView view = new DipiCollectionView();
                BeanUtils.copyProperties( dipiCollection , view );//把实体数据重构到view中

                //级联表
                    DipiEntity dipi = dipiService.selectById(dipiCollection.getDipiId());
                if(dipi != null){
                    BeanUtils.copyProperties( dipi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setDipiId(dipi.getId());
                }
                //级联表
                    KehuEntity kehu = kehuService.selectById(dipiCollection.getKehuId());
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
    public R add(@RequestBody DipiCollectionEntity dipiCollection, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,dipiCollection:{}",this.getClass().getName(),dipiCollection.toString());
        Wrapper<DipiCollectionEntity> queryWrapper = new EntityWrapper<DipiCollectionEntity>()
            .eq("dipi_id", dipiCollection.getDipiId())
            .eq("kehu_id", dipiCollection.getKehuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DipiCollectionEntity dipiCollectionEntity = dipiCollectionService.selectOne(queryWrapper);
        if(dipiCollectionEntity==null){
            dipiCollection.setInsertTime(new Date());
            dipiCollection.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      dipiCollection.set
        //  }
        dipiCollectionService.insert(dipiCollection);
            return R.ok();
        }else {
            return R.error(511,"您已经收藏过了");
        }
    }





}

