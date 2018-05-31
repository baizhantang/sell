package com.sunhao.sell.service.impl;

import com.sunhao.sell.Entity.ProductInfo;
import com.sunhao.sell.repository.ProductInfoRepository;
import org.junit.Assert;
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
        ProductInfo productInfo = repository.findOne("123123");
        Assert.assertNotNull(productInfo);
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
        productInfo.setProductId("123123");
        productInfo.setProductName("银杏周");
        productInfo.setCategoryType(1);
        productInfo.setProductDescription("这个是什么我也不知道，反正没吃过");
        productInfo.setProductIcon("http://xxxx.png");
        productInfo.setProductPrice(new BigDecimal(2.5));
        productInfo.setProductStock(100);

        repository.save(productInfo);
    }

    @Test
    public void increaseStock() {
    }

    @Test
    public void decreaseStock() {
    }
}