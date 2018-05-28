package com.sunhao.sell.Entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * created by sunhao
 * 2018/5/27
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    /**
     * 类目ID
     */
    @Id
    @GeneratedValue
    private int categoryId;

    /**
     * 类目名字
     */
    private String categoryName;

    /**
     * 类目编号
     */
    private int categoryType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
