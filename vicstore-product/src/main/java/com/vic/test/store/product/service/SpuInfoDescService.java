package com.vic.test.store.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vic.test.common.utils.PageUtils;
import com.vic.test.store.product.entity.SpuInfoDescEntity;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author vic
 * @email sunlightcs@gmail.com
 * @date 2020-11-01 19:05:07
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

