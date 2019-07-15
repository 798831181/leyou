package com.leyou.demo.controller;

import com.leyou.demo.service.SpecificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spec")
@Slf4j
public class SpecificationController {
    @Autowired
    private SpecificationService specificationService;
    @GetMapping("/{id}")
    public ResponseEntity<String> queryInfoById(@PathVariable("id") Long id){
        log.info("specificaitonContrtoller[] queryInfoById[] id:{} ", id);
        String info = specificationService.queryInfoById(id);
        return ResponseEntity.ok(info);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        specificationService.delete(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
