package com.entity.vo;

import com.entity.ZuowuzhuangtaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 作物状态
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zuowuzhuangtai")
public class ZuowuzhuangtaiVO implements Serializable {
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
     * 作物阶段
     */

    @TableField(value = "zuowuzhuangtai_jieduan_types")
    private Integer zuowuzhuangtaiJieduanTypes;


    /**
     * 作物状态
     */

    @TableField(value = "zuowuzhuangtai_types")
    private Integer zuowuzhuangtaiTypes;


    /**
     * 作物图片
     */

    @TableField(value = "zuowuzhuangtai_photo")
    private String zuowuzhuangtaiPhoto;


    /**
     * 当前详情
     */

    @TableField(value = "zuowuzhuangtai_content")
    private String zuowuzhuangtaiContent;


    /**
     * 发布时间
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
	 * 设置：作物阶段
	 */
    public Integer getZuowuzhuangtaiJieduanTypes() {
        return zuowuzhuangtaiJieduanTypes;
    }


    /**
	 * 获取：作物阶段
	 */

    public void setZuowuzhuangtaiJieduanTypes(Integer zuowuzhuangtaiJieduanTypes) {
        this.zuowuzhuangtaiJieduanTypes = zuowuzhuangtaiJieduanTypes;
    }
    /**
	 * 设置：作物状态
	 */
    public Integer getZuowuzhuangtaiTypes() {
        return zuowuzhuangtaiTypes;
    }


    /**
	 * 获取：作物状态
	 */

    public void setZuowuzhuangtaiTypes(Integer zuowuzhuangtaiTypes) {
        this.zuowuzhuangtaiTypes = zuowuzhuangtaiTypes;
    }
    /**
	 * 设置：作物图片
	 */
    public String getZuowuzhuangtaiPhoto() {
        return zuowuzhuangtaiPhoto;
    }


    /**
	 * 获取：作物图片
	 */

    public void setZuowuzhuangtaiPhoto(String zuowuzhuangtaiPhoto) {
        this.zuowuzhuangtaiPhoto = zuowuzhuangtaiPhoto;
    }
    /**
	 * 设置：当前详情
	 */
    public String getZuowuzhuangtaiContent() {
        return zuowuzhuangtaiContent;
    }


    /**
	 * 获取：当前详情
	 */

    public void setZuowuzhuangtaiContent(String zuowuzhuangtaiContent) {
        this.zuowuzhuangtaiContent = zuowuzhuangtaiContent;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发布时间
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
