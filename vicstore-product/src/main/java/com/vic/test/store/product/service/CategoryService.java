package com.vic.test.store.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vic.test.common.utils.PageUtils;
import com.vic.test.store.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author vic
 * @email sunlightcs@gmail.com
 * @date 2020-11-01 19:06:57
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listCategoryTree();
}

