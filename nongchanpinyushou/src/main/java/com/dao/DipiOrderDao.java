package com.dao;

import com.entity.DipiOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DipiOrderView;

/**
 * 地皮订单 Dao 接口
 *
 * @author 
 */
public interface DipiOrderDao extends BaseMapper<DipiOrderEntity> {

   List<DipiOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
