package com.hp.item.service;

import com.hp.item.mapper.CategoryMapper;
import com.hp.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CategoryService
 * @Description service层
 * @Author Ankhci
 * @Date 2020/1/1 18:07
 **/
@Service
public class CategoryService {

    @Autowired //DAO层
    private CategoryMapper categoryMapper;

    public List<Category> queryByParentId(Long id) {
        //select * from tb_category where parent_id = id;
        Category category = new Category();
        category.setParentId(id);
        return categoryMapper.select(category);
    }

    public List<Category> queryByBrandId(Long bid) {
        return categoryMapper.queryByBrandId(bid);
    }
}
