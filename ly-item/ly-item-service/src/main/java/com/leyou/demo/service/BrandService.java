package com.leyou.demo.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.leyou.common.pojo.PageResult;
import com.leyou.demo.Brand;
import com.leyou.demo.Category;
import com.leyou.demo.mapper.BrandMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;
    public PageResult<Brand> queryBrandByPageAndSort(Integer page, Integer rows, String sortBy, boolean desc, String key) {
        PageHelper.startPage(page,rows);
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)){
            example.createCriteria().andLike("name","%" + key +"%").orEqualTo("letter",key);
        }
        if (StringUtils.isNotBlank(sortBy)){
            String orderByClause = sortBy + (desc ? "DESC" : "ASC");
            example.setOrderByClause(orderByClause);
        }
        Page<Brand> pageInfo = (Page<Brand>) brandMapper.selectByExample(example);
        return new PageResult<>(pageInfo.getTotal(),pageInfo);
    }

    public void saveBrand(Brand brand, List<Long> cids) {
        brandMapper.insertSelective(brand);

        for (Long cid : cids) {
            brandMapper.insertCategoryBrand(cid,brand.getId());
        }
    }

    public List<Category> queryBrandById(Long bid) {
        return brandMapper.queryByBrandId(bid);
    }
    public void delete(Long bid){
        brandMapper.deleteByPrimaryKey(bid);
        brandMapper.deleteCategoryBrandRef(bid);
    }

}
