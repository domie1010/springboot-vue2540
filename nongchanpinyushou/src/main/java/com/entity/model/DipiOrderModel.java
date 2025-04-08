package com.entity.model;

import com.entity.DipiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 地皮订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DipiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 是否同意
     */
    private Integer dipiOrderYesnoTypes;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：地皮
	 */
    public Integer getDipiId() {
        return dipiId;
    }


    /**
	 * 设置：地皮
	 */
    public void setDipiId(Integer dipiId) {
        this.dipiId = dipiId;
    }
    /**
	 * 获取：客户
	 */
    public Integer getKehuId() {
        return kehuId;
    }


    /**
	 * 设置：客户
	 */
    public void setKehuId(Integer kehuId) {
        this.kehuId = kehuId;
    }
    /**
	 * 获取：作物名称
	 */
    public String getZuowuName() {
        return zuowuName;
    }


    /**
	 * 设置：作物名称
	 */
    public void setZuowuName(String zuowuName) {
        this.zuowuName = zuowuName;
    }
    /**
	 * 获取：作物类型
	 */
    public Integer getZuowuTypes() {
        return zuowuTypes;
    }


    /**
	 * 设置：作物类型
	 */
    public void setZuowuTypes(Integer zuowuTypes) {
        this.zuowuTypes = zuowuTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：是否同意
	 */
    public Integer getDipiOrderYesnoTypes() {
        return dipiOrderYesnoTypes;
    }


    /**
	 * 设置：是否同意
	 */
    public void setDipiOrderYesnoTypes(Integer dipiOrderYesnoTypes) {
        this.dipiOrderYesnoTypes = dipiOrderYesnoTypes;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
