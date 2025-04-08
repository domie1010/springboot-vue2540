package com.entity.view;

import com.entity.DingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("dingdan")
public class DingdanView extends DingdanEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 dipi_order
			/**
			* 地皮
			*/
			private Integer dipiId;
			/**
			* 客户
			*/
			private Integer kehuId;
			/**
			* 作物名称
			*/
			private String zuowuName;
			/**
			* 作物类型
			*/
			private Integer zuowuTypes;
				/**
				* 作物类型的值
				*/
				private String zuowuValue;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 订单创建时间
			*/
			private Date insertTime;
			/**
			* 是否同意
			*/
			private Integer dipiOrderYesnoTypes;
				/**
				* 是否同意的值
				*/
				private String dipiOrderYesnoValue;

		//级联表 kehu
			/**
			* 客户姓名
			*/
			private String kehuName;
			/**
			* 客户手机号
			*/
			private String kehuPhone;
			/**
			* 客户身份证号
			*/
			private String kehuIdNumber;
			/**
			* 现住地址
			*/
			private String kehuAddress;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 出生年月
			*/
			private Date kehuTime;
			/**
			* 客户照片
			*/
			private String kehuPhoto;

	public DingdanView() {

	}

	public DingdanView(DingdanEntity dingdanEntity) {
		try {
			BeanUtils.copyProperties(this, dingdanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}






















				//级联表的get和set dipi_order
					/**
					* 获取： 地皮
					*/
					public Integer getDipiId() {
						return dipiId;
					}
					/**
					* 设置： 地皮
					*/
					public void setDipiId(Integer dipiId) {
						this.dipiId = dipiId;
					}
					/**
					* 获取： 客户
					*/
					public Integer getKehuId() {
						return kehuId;
					}
					/**
					* 设置： 客户
					*/
					public void setKehuId(Integer kehuId) {
						this.kehuId = kehuId;
					}
					/**
					* 获取： 作物名称
					*/
					public String getZuowuName() {
						return zuowuName;
					}
					/**
					* 设置： 作物名称
					*/
					public void setZuowuName(String zuowuName) {
						this.zuowuName = zuowuName;
					}
					/**
					* 获取： 作物类型
					*/
					public Integer getZuowuTypes() {
						return zuowuTypes;
					}
					/**
					* 设置： 作物类型
					*/
					public void setZuowuTypes(Integer zuowuTypes) {
						this.zuowuTypes = zuowuTypes;
					}


						/**
						* 获取： 作物类型的值
						*/
						public String getZuowuValue() {
							return zuowuValue;
						}
						/**
						* 设置： 作物类型的值
						*/
						public void setZuowuValue(String zuowuValue) {
							this.zuowuValue = zuowuValue;
						}
					/**
					* 获取： 订单创建时间
					*/
					public Date getInsertTime() {
						return insertTime;
					}
					/**
					* 设置： 订单创建时间
					*/
					public void setInsertTime(Date insertTime) {
						this.insertTime = insertTime;
					}
					/**
					* 获取： 是否同意
					*/
					public Integer getDipiOrderYesnoTypes() {
						return dipiOrderYesnoTypes;
					}
					/**
					* 设置： 是否同意
					*/
					public void setDipiOrderYesnoTypes(Integer dipiOrderYesnoTypes) {
						this.dipiOrderYesnoTypes = dipiOrderYesnoTypes;
					}


						/**
						* 获取： 是否同意的值
						*/
						public String getDipiOrderYesnoValue() {
							return dipiOrderYesnoValue;
						}
						/**
						* 设置： 是否同意的值
						*/
						public void setDipiOrderYesnoValue(String dipiOrderYesnoValue) {
							this.dipiOrderYesnoValue = dipiOrderYesnoValue;
						}







				//级联表的get和set kehu
					/**
					* 获取： 客户姓名
					*/
					public String getKehuName() {
						return kehuName;
					}
					/**
					* 设置： 客户姓名
					*/
					public void setKehuName(String kehuName) {
						this.kehuName = kehuName;
					}
					/**
					* 获取： 客户手机号
					*/
					public String getKehuPhone() {
						return kehuPhone;
					}
					/**
					* 设置： 客户手机号
					*/
					public void setKehuPhone(String kehuPhone) {
						this.kehuPhone = kehuPhone;
					}
					/**
					* 获取： 客户身份证号
					*/
					public String getKehuIdNumber() {
						return kehuIdNumber;
					}
					/**
					* 设置： 客户身份证号
					*/
					public void setKehuIdNumber(String kehuIdNumber) {
						this.kehuIdNumber = kehuIdNumber;
					}
					/**
					* 获取： 现住地址
					*/
					public String getKehuAddress() {
						return kehuAddress;
					}
					/**
					* 设置： 现住地址
					*/
					public void setKehuAddress(String kehuAddress) {
						this.kehuAddress = kehuAddress;
					}
					/**
					* 获取： 出生年月
					*/
					public Date getKehuTime() {
						return kehuTime;
					}
					/**
					* 设置： 出生年月
					*/
					public void setKehuTime(Date kehuTime) {
						this.kehuTime = kehuTime;
					}
					/**
					* 获取： 客户照片
					*/
					public String getKehuPhoto() {
						return kehuPhoto;
					}
					/**
					* 设置： 客户照片
					*/
					public void setKehuPhoto(String kehuPhoto) {
						this.kehuPhoto = kehuPhoto;
					}






}
