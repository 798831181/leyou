package com.leyou.demo.mapper;

import com.leyou.demo.Brand;
import com.leyou.demo.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface BrandMapper extends Mapper<Brand> {
    /**
     * 新增商品分类和品牌中间表数据
     */
    @Insert("INSERT INTO tb_category_brand (category_id, brand_id) VALUES (#{cid},#{bid})")
    int insertCategoryBrand(@Param("cid") Long cid, @Param("bid") Long bid);
    /**
     * 根据品牌id，查询商品分类
     */
    @Select("select * from tb_category where id in (select category_id from tb_category_brand where brand_id = #{bid})" )
    List<Category> queryByBrandId(Long bid);


    @Delete("DELETE from tb_category_brand WHERE brand_id = #{bid} ")
    void deleteCategoryBrandRef(Long bid);
}
