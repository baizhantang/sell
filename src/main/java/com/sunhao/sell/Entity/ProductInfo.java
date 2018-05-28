package com.sunhao.sell.Entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author sunhao
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    /** ID编码. */
    @Id
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private int productStock;

    /** 描述. */
    private String productDescription;

    /** 图片. */
    private String productIcon;

    /** 状态 0正常，1下架. */
    private int productStatus;

    /** 类目编号. */
    private int categoryType;
}
