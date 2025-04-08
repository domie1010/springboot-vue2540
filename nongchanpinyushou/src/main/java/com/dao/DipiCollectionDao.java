package com.dao;

import com.entity.DipiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DipiCollectionView;

/**
 * 地皮收藏 Dao 接口
 *
 * @author 
 */
public interface DipiCollectionDao extends BaseMapper<DipiCollectionEntity> {

   List<DipiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
