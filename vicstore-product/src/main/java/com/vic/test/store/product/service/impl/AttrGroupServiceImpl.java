package com.vic.test.store.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vic.test.common.utils.PageUtils;
import com.vic.test.common.utils.Query;

import com.vic.test.store.product.dao.AttrGroupDao;
import com.vic.test.store.product.entity.AttrGroupEntity;
import com.vic.test.store.product.service.AttrGroupService;
import org.springframework.util.StringUtils;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
        String key = (String)params.get("key");
        if(catelogId==0){
            System.out.println("0...");
            IPage<AttrGroupEntity> page = this.page(
                    new Query<AttrGroupEntity>().getPage(params),
                    new QueryWrapper<AttrGroupEntity>()
            );
            return new PageUtils(page);
        }else{
            //select * from pms_attr_group where catelog_id=? and (attr_group_id=? or attr_group_name like %key%)
            //有三級分類id, 新增查詢條件
            //並判斷是否有關鍵字
            System.out.println("1...");
            QueryWrapper<AttrGroupEntity> wrapper=new QueryWrapper<AttrGroupEntity>().eq("catelog_id",catelogId);
            if(!StringUtils.isEmpty(key)){
                wrapper.and((obj)->{
                    obj.eq("attr_group_id",key).or().like("attr_group_name",key);
                });
            }
            IPage<AttrGroupEntity> page = this.page(
                    new Query<AttrGroupEntity>().getPage(params),wrapper
            );
            return new PageUtils(page);
        }




    }

}