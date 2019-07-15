package com.leyou.demo.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.demo.Brand;
import com.leyou.demo.Category;
import com.leyou.demo.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("brand")
@Slf4j
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 分页查询品牌
     *
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") boolean desc,
            @RequestParam(value = "key", required = false) String key) {

        PageResult<Brand> result = brandService.queryBrandByPageAndSort(page, rows, sortBy, desc, key);
        if (result == null || result.getItems().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

 /*   *
     * 新增品牌
     * @param brand
     * @param cids
     * @return*/

    @PostMapping()
    public ResponseEntity<Void> saveBrand(@RequestBody Brand brand, @RequestParam("cids") List<Long> cids) {
        log.info("leyou[] ly-item-service[] BrandController[] saveBrand[] param brand:{} cids: {}",brand, cids);
        brandService.saveBrand(brand, cids);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * 根据品牌id,查询商品分类
     * @param bid
     * @return
     */
    @GetMapping("bid/{bid}")
    public ResponseEntity<List<Category>> queryByBrandId(@PathVariable("bid") Long bid) {
        List<Category> categoryList = brandService.queryBrandById(bid);
        return ResponseEntity.ok(categoryList);
    }

    /**
     * 删除品牌
     * @param bid
     * @return
     */
    @GetMapping("delete/{bid}")
    public ResponseEntity<Void> delete(@PathVariable("bid") Long bid){
        log.info("bid: " + bid);
        brandService.delete(bid);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }
}
