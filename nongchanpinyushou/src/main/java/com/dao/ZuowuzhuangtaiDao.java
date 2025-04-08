package com.dao;

import com.entity.ZuowuzhuangtaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZuowuzhuangtaiView;

/**
 * 作物状态 Dao 接口
 *
 * @author 
 */
public interface ZuowuzhuangtaiDao extends BaseMapper<ZuowuzhuangtaiEntity> {

   List<ZuowuzhuangtaiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
