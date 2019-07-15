package com.leyou.demo.mapper;

import com.leyou.demo.Specification;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
public interface SpecificationMapper extends Mapper<Specification> {
    @Select("select * from tb_specification where category_id = #{id}")
    Specification queryInfoById(Long id);
    @Delete("delete from tb_specification where category_id = #{id}")
    void deleteById(Long id);

    /**
     * 删除商品信息
     * @param id
     */
    void deleteInfoById(Long id);

}
