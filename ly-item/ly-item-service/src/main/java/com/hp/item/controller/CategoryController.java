package com.hp.item.controller;

import com.hp.item.pojo.Category;
import com.hp.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName CategoryController
 * @Description 商品管理控制层
 * @Author Ankhci
 * @Date 2020/1/1 18:06
 **/
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryByParentId(@RequestParam("pid") Long id){
        List<Category> categoryList = categoryService.queryByParentId(id);
        if(null != categoryList && categoryList.size() != 0){
            //categoryList不为空，返回200响应码，
            return ResponseEntity.ok(categoryList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("bid/{bid}")
    public ResponseEntity<List<Category>> queryByBrandId(@PathVariable("bid") Long bid){
        List<Category> categoryList = categoryService.queryByBrandId(bid);
        if(categoryList != null && categoryList.size() > 0){
            //如果有数据就返回200跟数据
            return ResponseEntity.ok(categoryList);
        }
        //没有数据就返回没有数据
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
