package com.entity.vo;

import com.entity.DipiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 地皮订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("dipi_order")
public class DipiOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 是否同意
     */

    @TableField(value = "dipi_order_yesno_types")
    private Integer dipiOrderYesnoTypes;


    /**
     * 创建时间 show3
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
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
