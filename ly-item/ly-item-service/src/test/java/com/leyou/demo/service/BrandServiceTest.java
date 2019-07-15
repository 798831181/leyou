package com.leyou.demo.service;

import com.leyou.demo.basic.BasicTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BrandServiceTest extends BasicTest {
    @Autowired
    private BrandService brandService;

    @Test
    public void delete() {
        brandService.delete(199L);
    }
}
