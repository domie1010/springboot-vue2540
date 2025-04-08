package com.entity.view;

import com.entity.DipiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 地皮订单
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("dipi_order")
public class DipiOrderView extends DipiOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 作物类型的值
		*/
		private String zuowuValue;
		/**
		* 是否同意的值
		*/
		private String dipiOrderYesnoValue;



		//级联表 dipi
			/**
			* 地皮名称
			*/
			private String dipiName;
			/**
			* 地皮位置
			*/
			private String dipiWeizhi;
			/**
			* 地皮缩略图
			*/
			private String dipiPhoto;
			/**
			* 地皮价格
			*/
			private Double dipiNewMoney;
			/**
			* 地皮详情
			*/
			private String dipiContent;
			/**
			* 是否被使用
			*/
			private Integer dipiTypes;
				/**
				* 是否被使用的值
				*/
				private String dipiValue;

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

	public DipiOrderView() {

	}

	public DipiOrderView(DipiOrderEntity dipiOrderEntity) {
		try {
			BeanUtils.copyProperties(this, dipiOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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










				//级联表的get和set dipi
					/**
					* 获取： 地皮名称
					*/
					public String getDipiName() {
						return dipiName;
					}
					/**
					* 设置： 地皮名称
					*/
					public void setDipiName(String dipiName) {
						this.dipiName = dipiName;
					}
					/**
					* 获取： 地皮位置
					*/
					public String getDipiWeizhi() {
						return dipiWeizhi;
					}
					/**
					* 设置： 地皮位置
					*/
					public void setDipiWeizhi(String dipiWeizhi) {
						this.dipiWeizhi = dipiWeizhi;
					}
					/**
					* 获取： 地皮缩略图
					*/
					public String getDipiPhoto() {
						return dipiPhoto;
					}
					/**
					* 设置： 地皮缩略图
					*/
					public void setDipiPhoto(String dipiPhoto) {
						this.dipiPhoto = dipiPhoto;
					}
					/**
					* 获取： 地皮价格
					*/
					public Double getDipiNewMoney() {
						return dipiNewMoney;
					}
					/**
					* 设置： 地皮价格
					*/
					public void setDipiNewMoney(Double dipiNewMoney) {
						this.dipiNewMoney = dipiNewMoney;
					}
					/**
					* 获取： 地皮详情
					*/
					public String getDipiContent() {
						return dipiContent;
					}
					/**
					* 设置： 地皮详情
					*/
					public void setDipiContent(String dipiContent) {
						this.dipiContent = dipiContent;
					}
					/**
					* 获取： 是否被使用
					*/
					public Integer getDipiTypes() {
						return dipiTypes;
					}
					/**
					* 设置： 是否被使用
					*/
					public void setDipiTypes(Integer dipiTypes) {
						this.dipiTypes = dipiTypes;
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
