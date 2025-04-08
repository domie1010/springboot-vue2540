package com.dao;

import com.entity.DipiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DipiView;

/**
 * 地皮 Dao 接口
 *
 * @author 
 */
public interface DipiDao extends BaseMapper<DipiEntity> {

   List<DipiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
