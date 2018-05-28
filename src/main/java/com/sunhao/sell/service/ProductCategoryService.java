package com.sunhao.sell.service;

import com.sunhao.sell.Entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    ProductCategory findOne(int categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
