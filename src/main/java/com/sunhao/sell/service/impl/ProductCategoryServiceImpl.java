package com.sunhao.sell.service.impl;

import com.sunhao.sell.Entity.ProductCategory;
import com.sunhao.sell.repository.ProductCategoryRepo;
import com.sunhao.sell.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunhao
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepo repo;

    @Override
    public ProductCategory findOne(int categoryId) {
        return repo.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repo.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repo.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repo.save(productCategory);
    }
}
