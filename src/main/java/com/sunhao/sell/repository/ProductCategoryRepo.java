package com.sunhao.sell.repository;

import com.sunhao.sell.Entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * created by sunhao
 * 2018/5/27
 */
public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
