package com.hp.item.mapper;

import com.hp.item.pojo.Category;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryMapper extends Mapper<Category> {

    //手写SQL语句
    @Select("select c.* from tb_category c,tb_category_brand cb where c.id = cb.category_id and brand_id = #{bid}")
    List<Category> queryByBrandId(@Param("bid") Long bid);
}
