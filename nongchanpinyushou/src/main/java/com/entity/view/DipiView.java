package com.entity.view;

import com.entity.DipiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 地皮
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("dipi")
public class DipiView extends DipiEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 是否被使用的值
		*/
		private String dipiValue;



	public DipiView() {

	}

	public DipiView(DipiEntity dipiEntity) {
		try {
			BeanUtils.copyProperties(this, dipiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 是否被使用的值
			*/
			public String getDipiValue() {
				return dipiValue;
			}
			/**
			* 设置： 是否被使用的值
			*/
			public void setDipiValue(String dipiValue) {
				this.dipiValue = dipiValue;
			}












}
