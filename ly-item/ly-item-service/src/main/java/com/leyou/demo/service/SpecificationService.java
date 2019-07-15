package com.leyou.demo.service;

import com.leyou.demo.Specification;
import com.leyou.demo.mapper.SpecificationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;

@Service
@Slf4j
public class SpecificationService {
    @Autowired
    private SpecificationMapper specificationMapper;
    public String queryInfoById(Long id){
        log.info("specificaition[] queryInfoById[] id; {}", id);
        System.out.println(specificationMapper);
        Specification specification = specificationMapper.queryInfoById(id);
        return specification.getSpecifications();
    }

    public void delete(long id) {
        log.info("specificaition[] deleteInfoById[] id; {}", id);
//        specificationMapper.deleteById(id);
        specificationMapper.deleteInfoById(id);

    }


//    public static void main(String[] args) {
//
//        SpecificationService service = new SpecificationService();
//        String s = service.queryInfoById((long) 76);
//        System.out.println(s);
//    }

}
