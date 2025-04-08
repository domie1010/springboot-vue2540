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
 * 客户
 *
 * @author 
 * @email
 */
@TableName("kehu")
public class KehuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KehuEntity() {

	}

	public KehuEntity(T t) {
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
     * 账户
     */
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @TableField(value = "password")

    private String password;


    /**
     * 客户姓名
     */
    @TableField(value = "kehu_name")

    private String kehuName;


    /**
     * 客户手机号
     */
    @TableField(value = "kehu_phone")

    private String kehuPhone;


    /**
     * 客户身份证号
     */
    @TableField(value = "kehu_id_number")

    private String kehuIdNumber;


    /**
     * 现住地址
     */
    @TableField(value = "kehu_address")

    private String kehuAddress;


    /**
     * 出生年月
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "kehu_time",fill = FieldFill.UPDATE)

    private Date kehuTime;


    /**
     * 客户照片
     */
    @TableField(value = "kehu_photo")

    private String kehuPhoto;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：客户姓名
	 */
    public String getKehuName() {
        return kehuName;
    }


    /**
	 * 获取：客户姓名
	 */

    public void setKehuName(String kehuName) {
        this.kehuName = kehuName;
    }
    /**
	 * 设置：客户手机号
	 */
    public String getKehuPhone() {
        return kehuPhone;
    }


    /**
	 * 获取：客户手机号
	 */

    public void setKehuPhone(String kehuPhone) {
        this.kehuPhone = kehuPhone;
    }
    /**
	 * 设置：客户身份证号
	 */
    public String getKehuIdNumber() {
        return kehuIdNumber;
    }


    /**
	 * 获取：客户身份证号
	 */

    public void setKehuIdNumber(String kehuIdNumber) {
        this.kehuIdNumber = kehuIdNumber;
    }
    /**
	 * 设置：现住地址
	 */
    public String getKehuAddress() {
        return kehuAddress;
    }


    /**
	 * 获取：现住地址
	 */

    public void setKehuAddress(String kehuAddress) {
        this.kehuAddress = kehuAddress;
    }
    /**
	 * 设置：出生年月
	 */
    public Date getKehuTime() {
        return kehuTime;
    }


    /**
	 * 获取：出生年月
	 */

    public void setKehuTime(Date kehuTime) {
        this.kehuTime = kehuTime;
    }
    /**
	 * 设置：客户照片
	 */
    public String getKehuPhoto() {
        return kehuPhoto;
    }


    /**
	 * 获取：客户照片
	 */

    public void setKehuPhoto(String kehuPhoto) {
        this.kehuPhoto = kehuPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
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
        return "Kehu{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", kehuName=" + kehuName +
            ", kehuPhone=" + kehuPhone +
            ", kehuIdNumber=" + kehuIdNumber +
            ", kehuAddress=" + kehuAddress +
            ", kehuTime=" + kehuTime +
            ", kehuPhoto=" + kehuPhoto +
            ", sexTypes=" + sexTypes +
            ", createTime=" + createTime +
        "}";
    }
}
