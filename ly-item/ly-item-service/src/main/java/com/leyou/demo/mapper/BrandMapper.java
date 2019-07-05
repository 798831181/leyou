package com.leyou.demo.mapper;

import com.leyou.demo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface BrandMapper extends Mapper<Brand> {
    @Insert("insert into tb_category_brand values(#{cid},#{bid})")
    /**
     * 新增商品分类和品牌中间表数据
     */
    int insertCategoryBrand(@Param("cid") Long cid, @Param("bid") Long bid);

}
