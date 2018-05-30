package com.sunhao.sell.service.impl;

import com.sunhao.sell.Entity.ProductInfo;
import com.sunhao.sell.repository.ProductInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findOne() {
    }

    @Test
    public void findUpAll() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123123123");
        productInfo.setProductName("八宝粥");
        productInfo.setCategoryType(3);
        productInfo.setProductDescription("这个东西管饱");
        productInfo.setProductIcon("http://xxxx.jpg");
        productInfo.setProductPrice(new BigDecimal(1024));
        productInfo.setProductStock(1000);

        repository.save(productInfo);
    }

    @Test
    public void increaseStock() {
    }

    @Test
    public void decreaseStock() {
    }
}