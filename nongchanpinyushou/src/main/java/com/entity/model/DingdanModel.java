package com.entity.model;

import com.entity.DingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DingdanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 作物
     */
    private Integer dipiOrderId;


    /**
     * 客户
     */
    private Integer kehuId;


    /**
     * 发货物品
     */
    private String dingdanWupin;


    /**
     * 发货数量
     */
    private Integer wupinNumber;


    /**
     * 收货人
     */
    private String xingming;


    /**
     * 收货人手机号
     */
    private String shouhuorenPhone;


    /**
     * 收货地址
     */
    private String address;


    /**
     * 单号
     */
    private String dingdanDanhaoNumber;


    /**
     * 备注
     */
    private String zuowuzhuangtaiContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：作物
	 */
    public Integer getDipiOrderId() {
        return dipiOrderId;
    }


    /**
	 * 设置：作物
	 */
    public void setDipiOrderId(Integer dipiOrderId) {
        this.dipiOrderId = dipiOrderId;
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
	 * 获取：发货物品
	 */
    public String getDingdanWupin() {
        return dingdanWupin;
    }


    /**
	 * 设置：发货物品
	 */
    public void setDingdanWupin(String dingdanWupin) {
        this.dingdanWupin = dingdanWupin;
    }
    /**
	 * 获取：发货数量
	 */
    public Integer getWupinNumber() {
        return wupinNumber;
    }


    /**
	 * 设置：发货数量
	 */
    public void setWupinNumber(Integer wupinNumber) {
        this.wupinNumber = wupinNumber;
    }
    /**
	 * 获取：收货人
	 */
    public String getXingming() {
        return xingming;
    }


    /**
	 * 设置：收货人
	 */
    public void setXingming(String xingming) {
        this.xingming = xingming;
    }
    /**
	 * 获取：收货人手机号
	 */
    public String getShouhuorenPhone() {
        return shouhuorenPhone;
    }


    /**
	 * 设置：收货人手机号
	 */
    public void setShouhuorenPhone(String shouhuorenPhone) {
        this.shouhuorenPhone = shouhuorenPhone;
    }
    /**
	 * 获取：收货地址
	 */
    public String getAddress() {
        return address;
    }


    /**
	 * 设置：收货地址
	 */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
	 * 获取：单号
	 */
    public String getDingdanDanhaoNumber() {
        return dingdanDanhaoNumber;
    }


    /**
	 * 设置：单号
	 */
    public void setDingdanDanhaoNumber(String dingdanDanhaoNumber) {
        this.dingdanDanhaoNumber = dingdanDanhaoNumber;
    }
    /**
	 * 获取：备注
	 */
    public String getZuowuzhuangtaiContent() {
        return zuowuzhuangtaiContent;
    }


    /**
	 * 设置：备注
	 */
    public void setZuowuzhuangtaiContent(String zuowuzhuangtaiContent) {
        this.zuowuzhuangtaiContent = zuowuzhuangtaiContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
