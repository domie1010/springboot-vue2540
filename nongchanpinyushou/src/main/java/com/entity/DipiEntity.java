package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 地皮
 *
 * @author 
 * @email
 */
@TableName("dipi")
public class DipiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DipiEntity() {

	}

	public DipiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 地皮名称
     */
    @TableField(value = "dipi_name")

    private String dipiName;


    /**
     * 地皮位置
     */
    @TableField(value = "dipi_weizhi")

    private String dipiWeizhi;


    /**
     * 地皮缩略图
     */
    @TableField(value = "dipi_photo")

    private String dipiPhoto;


    /**
     * 地皮价格
     */
    @TableField(value = "dipi_new_money")

    private Double dipiNewMoney;


    /**
     * 地皮详情
     */
    @TableField(value = "dipi_content")

    private String dipiContent;


    /**
     * 是否被使用
     */
    @TableField(value = "dipi_types")

    private Integer dipiTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：地皮名称
	 */
    public String getDipiName() {
        return dipiName;
    }


    /**
	 * 获取：地皮名称
	 */

    public void setDipiName(String dipiName) {
        this.dipiName = dipiName;
    }
    /**
	 * 设置：地皮位置
	 */
    public String getDipiWeizhi() {
        return dipiWeizhi;
    }


    /**
	 * 获取：地皮位置
	 */

    public void setDipiWeizhi(String dipiWeizhi) {
        this.dipiWeizhi = dipiWeizhi;
    }
    /**
	 * 设置：地皮缩略图
	 */
    public String getDipiPhoto() {
        return dipiPhoto;
    }


    /**
	 * 获取：地皮缩略图
	 */

    public void setDipiPhoto(String dipiPhoto) {
        this.dipiPhoto = dipiPhoto;
    }
    /**
	 * 设置：地皮价格
	 */
    public Double getDipiNewMoney() {
        return dipiNewMoney;
    }


    /**
	 * 获取：地皮价格
	 */

    public void setDipiNewMoney(Double dipiNewMoney) {
        this.dipiNewMoney = dipiNewMoney;
    }
    /**
	 * 设置：地皮详情
	 */
    public String getDipiContent() {
        return dipiContent;
    }


    /**
	 * 获取：地皮详情
	 */

    public void setDipiContent(String dipiContent) {
        this.dipiContent = dipiContent;
    }
    /**
	 * 设置：是否被使用
	 */
    public Integer getDipiTypes() {
        return dipiTypes;
    }


    /**
	 * 获取：是否被使用
	 */

    public void setDipiTypes(Integer dipiTypes) {
        this.dipiTypes = dipiTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Dipi{" +
            "id=" + id +
            ", dipiName=" + dipiName +
            ", dipiWeizhi=" + dipiWeizhi +
            ", dipiPhoto=" + dipiPhoto +
            ", dipiNewMoney=" + dipiNewMoney +
            ", dipiContent=" + dipiContent +
            ", dipiTypes=" + dipiTypes +
            ", createTime=" + createTime +
        "}";
    }
}
