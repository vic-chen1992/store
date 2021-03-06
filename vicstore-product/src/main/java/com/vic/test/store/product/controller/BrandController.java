package com.vic.test.store.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.vic.test.common.valid.AddGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vic.test.store.product.entity.BrandEntity;
import com.vic.test.store.product.service.BrandService;
import com.vic.test.common.utils.PageUtils;
import com.vic.test.common.utils.R;

import javax.validation.Valid;


/**
 * 品牌
 *
 * @author vic
 * @email sunlightcs@gmail.com
 * @date 2020-11-01 19:06:57
 */
@RestController
@RequestMapping("product/brand")
@RefreshScope

public class BrandController {
    @Autowired
    private BrandService brandService;
    @Value("${user.name}")
    String name;


    @RequestMapping("/test")
    public R test(){
        Map map=new HashMap();

        map.put("name",name);
        return R.ok(map);

    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:brand:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    //@RequiresPermissions("product:brand:info")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:brand:save")
    public R save(@RequestBody @Validated({AddGroup.class}) BrandEntity brand/*, BindingResult result*/){
        //處理jsr303
//        if(result.hasErrors()){
//            System.out.println("有錯誤");
//            List<FieldError> fieldErrors = result.getFieldErrors();
//            Map map=new HashMap();
//            fieldErrors.forEach(item->{
//                String defaultMessage = item.getDefaultMessage();
//                String field = item.getField();
//                map.put(field,defaultMessage);
//            });
//
//            return R.error(400,"數據不合法").put("errors",map);
//        }else{

        //改交由統一異常類處理
            brandService.save(brand);
            return R.ok();
 //       }




    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:brand:update")
    public R update(@RequestBody BrandEntity brand){

        brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:brand:delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
