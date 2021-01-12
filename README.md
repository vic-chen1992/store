前端
module/product/attrgroup
屬性頁面, 包含分類(引用components)及屬性
父子組件傳遞數據
1.子組件給父組件傳遞數據, 事件機制; 子組件給父組件發送一個事件,並攜帶數據
this.$emit("tree-node-click",node,data,component)

後端(獲取分類屬性分組)
Controller
@GetMapping("/list/{catelogId}")
 public R list(@RequestParam Map<String, Object> params,@PathVariable Long catelogId)
 
 Service
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
			//select * from pms_attr_group where catelog_id=? and (attr_group_id=? or 			  attr_group_name like %key%)
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