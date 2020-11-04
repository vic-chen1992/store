package com.vic.test.store.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vic.test.common.utils.PageUtils;
import com.vic.test.store.product.entity.CommentReplayEntity;

import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author vic
 * @email sunlightcs@gmail.com
 * @date 2020-11-01 19:05:07
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

