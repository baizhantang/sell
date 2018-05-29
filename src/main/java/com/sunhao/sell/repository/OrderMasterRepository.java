package com.sunhao.sell.repository;

import com.sunhao.sell.Entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sunhao
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    Page<OrderMaster> findAllByBuyerOpenid(String buyerOpenid, Pageable pageable);


}
