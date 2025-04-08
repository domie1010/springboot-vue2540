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
 * 地皮订单
 *
 * @author 
 * @email
 */
@TableName("dipi_order")
public class DipiOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DipiOrderEntity() {

	}

	public DipiOrderEntity(T t) {
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
     * 地皮
     */
    @TableField(value = "dipi_id")

    private Integer dipiId;


    /**
     * 客户
     */
    @TableField(value = "kehu_id")

    private Integer kehuId;


    /**
     * 作物名称
     */
    @TableField(value = "zuowu_name")

    private String zuowuName;


    /**
     * 作物类型
     */
    @TableField(value = "zuowu_types")

    private Integer zuowuTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 是否同意
     */
    @TableField(value = "dipi_order_yesno_types")

    private Integer dipiOrderYesnoTypes;


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
	 * 设置：地皮
	 */
    public Integer getDipiId() {
        return dipiId;
    }


    /**
	 * 获取：地皮
	 */

    public void setDipiId(Integer dipiId) {
        this.dipiId = dipiId;
    }
    /**
	 * 设置：客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 获取：客户
	 */

    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 设置：作物名称
	 */
    public String getZuowuName() {
        return zuowuName;
    }


    /**
	 * 获取：作物名称
	 */

    public void setZuowuName(String zuowuName) {
        this.zuowuName = zuowuName;
    }
    /**
	 * 设置：作物类型
	 */
    public Integer getZuowuTypes() {
        return zuowuTypes;
    }


    /**
	 * 获取：作物类型
	 */

    public void setZuowuTypes(Integer zuowuTypes) {
        this.zuowuTypes = zuowuTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：是否同意
	 */
    public Integer getDipiOrderYesnoTypes() {
        return dipiOrderYesnoTypes;
    }


    /**
	 * 获取：是否同意
	 */

    public void setDipiOrderYesnoTypes(Integer dipiOrderYesnoTypes) {
        this.dipiOrderYesnoTypes = dipiOrderYesnoTypes;
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
        return "DipiOrder{" +
            "id=" + id +
            ", dipiId=" + dipiId +
            ", kehuId=" + kehuId +
            ", zuowuName=" + zuowuName +
            ", zuowuTypes=" + zuowuTypes +
            ", insertTime=" + insertTime +
            ", dipiOrderYesnoTypes=" + dipiOrderYesnoTypes +
            ", createTime=" + createTime +
        "}";
    }
}
