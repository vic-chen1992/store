package com.vic.test.store.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vic.test.store.product.entity.CategoryEntity;
import com.vic.test.store.product.service.CategoryService;
import com.vic.test.common.utils.PageUtils;
import com.vic.test.common.utils.R;



/**
 * 商品三级分类
 *
 * @author vic
 * @email sunlightcs@gmail.com
 * @date 2020-11-01 19:06:57
 */
@Api("category")
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     *  獲取所有3級分類
     */
    @RequestMapping("/list/all")
    //@RequiresPermissions("product:category:list")
    public R list(){
        List<CategoryEntity> list = categoryService.listCategoryTree();

        return R.ok().put("categoryTree", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] catIds){
		categoryService.removeByCatIds(Arrays.asList(catIds));

        return R.ok();
    }

}
