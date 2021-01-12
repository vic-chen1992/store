package com.vic.test.store.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.vic.test.common.valid.AddGroup;
import com.vic.test.common.valid.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author vic
 * @email sunlightcs@gmail.com
 * @date 2020-11-01 19:06:57
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	@Null(message = "新增不指定id",groups ={AddGroup.class} )
	@NotNull(message = "更新需要id",groups = {UpdateGroup.class})
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌必須提交",groups = {AddGroup.class,UpdateGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@URL(message = "必須是合法url",groups = {AddGroup.class,UpdateGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotEmpty(groups = {AddGroup.class})
	@Pattern(regexp="^[a-zA-Z]/",message = "必須是一個因文字母",groups = {AddGroup.class,UpdateGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(message = "不可維空",groups = {AddGroup.class})
	@Min(value = 0,message = "排序必须大于等于0",groups = {AddGroup.class,UpdateGroup.class})
	private Integer sort;

}
