package com.sunhao.sell.controller;

import com.sunhao.sell.Entity.ProductCategory;
import com.sunhao.sell.Entity.ProductInfo;
import com.sunhao.sell.VO.ProductInfoVO;
import com.sunhao.sell.VO.ProductVO;
import com.sunhao.sell.VO.ResultVO;
import com.sunhao.sell.service.ProductCategoryService;
import com.sunhao.sell.service.ProductInfoService;
import com.sunhao.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunhao
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public ResultVO list() {
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();

        //2.根据上架的商品查询类目（一次性查询）
        //传统方法
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for (ProductInfo productInfo :
//             productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法（java8， lambda表达式）
        List<Integer> categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        //循环把所有上架的商品按照类目分开，并且把商品详细信息转换成ProductInfoVO
        for (ProductCategory productCategory :
                productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo :
                    productInfoList) {
                if (productInfo.getCategoryType() == productCategory.getCategoryType()) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //把ProductInfo的值复制到ProductInfoVO
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }
}
