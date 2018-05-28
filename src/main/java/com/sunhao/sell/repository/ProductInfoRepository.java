package com.sunhao.sell.repository;

import com.sunhao.sell.Entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author sunhao
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findAllByProductStatus(int productStatus);
}
