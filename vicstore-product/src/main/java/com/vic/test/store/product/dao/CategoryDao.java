package com.vic.test.store.product.dao;

import com.vic.test.store.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author vic
 * @email sunlightcs@gmail.com
 * @date 2020-11-01 19:06:57
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
