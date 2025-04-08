package com.entity.model;

import com.entity.DipiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 地皮
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DipiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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
     * 创建时间 show1 show2 photoShow
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
	 * 获取：地皮名称
	 */
    public String getDipiName() {
        return dipiName;
    }


    /**
	 * 设置：地皮名称
	 */
    public void setDipiName(String dipiName) {
        this.dipiName = dipiName;
    }
    /**
	 * 获取：地皮位置
	 */
    public String getDipiWeizhi() {
        return dipiWeizhi;
    }


    /**
	 * 设置：地皮位置
	 */
    public void setDipiWeizhi(String dipiWeizhi) {
        this.dipiWeizhi = dipiWeizhi;
    }
    /**
	 * 获取：地皮缩略图
	 */
    public String getDipiPhoto() {
        return dipiPhoto;
    }


    /**
	 * 设置：地皮缩略图
	 */
    public void setDipiPhoto(String dipiPhoto) {
        this.dipiPhoto = dipiPhoto;
    }
    /**
	 * 获取：地皮价格
	 */
    public Double getDipiNewMoney() {
        return dipiNewMoney;
    }


    /**
	 * 设置：地皮价格
	 */
    public void setDipiNewMoney(Double dipiNewMoney) {
        this.dipiNewMoney = dipiNewMoney;
    }
    /**
	 * 获取：地皮详情
	 */
    public String getDipiContent() {
        return dipiContent;
    }


    /**
	 * 设置：地皮详情
	 */
    public void setDipiContent(String dipiContent) {
        this.dipiContent = dipiContent;
    }
    /**
	 * 获取：是否被使用
	 */
    public Integer getDipiTypes() {
        return dipiTypes;
    }


    /**
	 * 设置：是否被使用
	 */
    public void setDipiTypes(Integer dipiTypes) {
        this.dipiTypes = dipiTypes;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
