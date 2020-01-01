package com.hp.item.service;

/**
 * @ClassName BrandService
 * @Description 品牌管理服务层
 * @Author Ankhci
 * @Date 2020/1/2 0:09
 **/

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hp.item.mapper.BrandMapper;
import com.hp.item.pojo.Brand;
import com.hp.common.pojo.PageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;

    public PageResult<Brand> pageQuery(Integer page, Integer rows, String sortBy, Boolean desc, String key) {

        //select count(*) from brand where name like %key% order by sortBy desc
        //select * from brand limit 0,5
        //select * from brand where name like %key% order by sortBy desc

        //使用分页助手
        PageHelper.startPage(page,rows);
        //查询条件
        Example example = new Example(Brand.class);

        if (StringUtils.isNotBlank(key)){
            //获得对象
            Example.Criteria criteria = example.createCriteria();
            criteria.andLike("name","%"+key+"%");
        }
        //排序
        if (StringUtils.isNotBlank(sortBy)){
            //order by id desc
            example.setOrderByClause(sortBy + (desc ? " desc":" asc"));
        }
        //select * from brand where name like %key% order by sortBy desc
        Page<Brand> brandPage= (Page<Brand>)brandMapper.selectByExample(example);

        return new PageResult<>(brandPage.getTotal(),new Long(brandPage.getPages()),brandPage.getResult());
    }
}
