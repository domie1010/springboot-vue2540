package com.entity.vo;

import com.entity.DingdanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("dingdan")
public class DingdanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 作物
     */

    @TableField(value = "dipi_order_id")
    private Integer dipiOrderId;


    /**
     * 客户
     */

    @TableField(value = "kehu_id")
    private Integer kehuId;


    /**
     * 发货物品
     */

    @TableField(value = "dingdan_wupin")
    private String dingdanWupin;


    /**
     * 发货数量
     */

    @TableField(value = "wupin_number")
    private Integer wupinNumber;


    /**
     * 收货人
     */

    @TableField(value = "xingming")
    private String xingming;


    /**
     * 收货人手机号
     */

    @TableField(value = "shouhuoren_phone")
    private String shouhuorenPhone;


    /**
     * 收货地址
     */

    @TableField(value = "address")
    private String address;


    /**
     * 单号
     */

    @TableField(value = "dingdan_danhao_number")
    private String dingdanDanhaoNumber;


    /**
     * 备注
     */

    @TableField(value = "zuowuzhuangtai_content")
    private String zuowuzhuangtaiContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：作物
	 */
    public Integer getDipiOrderId() {
        return dipiOrderId;
    }


    /**
	 * 获取：作物
	 */

    public void setDipiOrderId(Integer dipiOrderId) {
        this.dipiOrderId = dipiOrderId;
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
	 * 设置：发货物品
	 */
    public String getDingdanWupin() {
        return dingdanWupin;
    }


    /**
	 * 获取：发货物品
	 */

    public void setDingdanWupin(String dingdanWupin) {
        this.dingdanWupin = dingdanWupin;
    }
    /**
	 * 设置：发货数量
	 */
    public Integer getWupinNumber() {
        return wupinNumber;
    }


    /**
	 * 获取：发货数量
	 */

    public void setWupinNumber(Integer wupinNumber) {
        this.wupinNumber = wupinNumber;
    }
    /**
	 * 设置：收货人
	 */
    public String getXingming() {
        return xingming;
    }


    /**
	 * 获取：收货人
	 */

    public void setXingming(String xingming) {
        this.xingming = xingming;
    }
    /**
	 * 设置：收货人手机号
	 */
    public String getShouhuorenPhone() {
        return shouhuorenPhone;
    }


    /**
	 * 获取：收货人手机号
	 */

    public void setShouhuorenPhone(String shouhuorenPhone) {
        this.shouhuorenPhone = shouhuorenPhone;
    }
    /**
	 * 设置：收货地址
	 */
    public String getAddress() {
        return address;
    }


    /**
	 * 获取：收货地址
	 */

    public void setAddress(String address) {
        this.address = address;
    }
    /**
	 * 设置：单号
	 */
    public String getDingdanDanhaoNumber() {
        return dingdanDanhaoNumber;
    }


    /**
	 * 获取：单号
	 */

    public void setDingdanDanhaoNumber(String dingdanDanhaoNumber) {
        this.dingdanDanhaoNumber = dingdanDanhaoNumber;
    }
    /**
	 * 设置：备注
	 */
    public String getZuowuzhuangtaiContent() {
        return zuowuzhuangtaiContent;
    }


    /**
	 * 获取：备注
	 */

    public void setZuowuzhuangtaiContent(String zuowuzhuangtaiContent) {
        this.zuowuzhuangtaiContent = zuowuzhuangtaiContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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

}
