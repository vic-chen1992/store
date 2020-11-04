package com.vic.test.store.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vic.test.common.utils.PageUtils;
import com.vic.test.store.product.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author vic
 * @email sunlightcs@gmail.com
 * @date 2020-11-01 19:05:07
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

