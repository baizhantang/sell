package com.sunhao.sell.repository;

import com.sunhao.sell.Entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by sunhao
 * 2018/5/27
 */
public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Integer> {

}
