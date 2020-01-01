package com.hp.item.controller;

import com.hp.item.pojo.Brand;
import com.hp.item.service.BrandService;
import com.hp.common.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BrandController
 * @Description Brand品牌管理控制层
 * @Author Ankhci
 * @Date 2020/1/2 0:08
 **/
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    //page=1    rows=5    sortBy=id    desc=false    key=
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> pageQuery(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                       @RequestParam(value = "rows",defaultValue = "5") Integer rows,
                                                       @RequestParam(value = "sortBy",required = false) String sortBy,
                                                       @RequestParam(value = "desc",required = false) Boolean desc,
                                                       @RequestParam(value = "key",required = false) String key
                                       ){
        PageResult<Brand> brandPageResult = brandService.pageQuery(page,rows,sortBy,desc,key);
        if(null!=brandPageResult&&brandPageResult.getItems().size()>0){
            return ResponseEntity.ok(brandPageResult);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
