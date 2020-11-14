package com.vic.test.store.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vic.test.common.utils.PageUtils;
import com.vic.test.common.utils.Query;

import com.vic.test.store.product.dao.CategoryDao;
import com.vic.test.store.product.entity.CategoryEntity;
import com.vic.test.store.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listCategoryTree() {
        //查詢所有
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);

        List<CategoryEntity> result=categoryEntities.stream().filter(entity->
            entity.getParentCid()==0

        ).map(test->{
            test.setList(setCategoryChild(test,categoryEntities));
            return test;
        }).sorted((test1,test2)->{
            return test1.getSort()-test2.getSort();
        }).collect(Collectors.toList());

        return result;
    }

    @Override
    public void removeByCatIds(List<Long> asList) {
        //TODO 判斷是否可以刪除
        int result = baseMapper.deleteBatchIds(asList);
        System.out.println("categoryids是否刪除成功:"+result);

    }

    private List<CategoryEntity> setCategoryChild(CategoryEntity test, List<CategoryEntity> categoryEntities) {

        List<CategoryEntity> result=categoryEntities.stream().filter(entity-> {

            return entity.getParentCid() == test.getCatId();
        }).map(entity->{
           entity.setList(setCategoryChild(entity,categoryEntities));
           return entity;

        }).collect(Collectors.toList());

        return result;

    }

}