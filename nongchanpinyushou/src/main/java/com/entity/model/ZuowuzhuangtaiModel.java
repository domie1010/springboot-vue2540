package com.entity.model;

import com.entity.ZuowuzhuangtaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 作物状态
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZuowuzhuangtaiModel implements Serializable {
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
     * 作物阶段
     */
    private Integer zuowuzhuangtaiJieduanTypes;


    /**
     * 作物状态
     */
    private Integer zuowuzhuangtaiTypes;


    /**
     * 作物图片
     */
    private String zuowuzhuangtaiPhoto;


    /**
     * 当前详情
     */
    private String zuowuzhuangtaiContent;


    /**
     * 发布时间
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
	 * 获取：作物阶段
	 */
    public Integer getZuowuzhuangtaiJieduanTypes() {
        return zuowuzhuangtaiJieduanTypes;
    }


    /**
	 * 设置：作物阶段
	 */
    public void setZuowuzhuangtaiJieduanTypes(Integer zuowuzhuangtaiJieduanTypes) {
        this.zuowuzhuangtaiJieduanTypes = zuowuzhuangtaiJieduanTypes;
    }
    /**
	 * 获取：作物状态
	 */
    public Integer getZuowuzhuangtaiTypes() {
        return zuowuzhuangtaiTypes;
    }


    /**
	 * 设置：作物状态
	 */
    public void setZuowuzhuangtaiTypes(Integer zuowuzhuangtaiTypes) {
        this.zuowuzhuangtaiTypes = zuowuzhuangtaiTypes;
    }
    /**
	 * 获取：作物图片
	 */
    public String getZuowuzhuangtaiPhoto() {
        return zuowuzhuangtaiPhoto;
    }


    /**
	 * 设置：作物图片
	 */
    public void setZuowuzhuangtaiPhoto(String zuowuzhuangtaiPhoto) {
        this.zuowuzhuangtaiPhoto = zuowuzhuangtaiPhoto;
    }
    /**
	 * 获取：当前详情
	 */
    public String getZuowuzhuangtaiContent() {
        return zuowuzhuangtaiContent;
    }


    /**
	 * 设置：当前详情
	 */
    public void setZuowuzhuangtaiContent(String zuowuzhuangtaiContent) {
        this.zuowuzhuangtaiContent = zuowuzhuangtaiContent;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：发布时间
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
