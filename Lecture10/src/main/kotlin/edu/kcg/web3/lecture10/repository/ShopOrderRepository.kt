package edu.kcg.web3.lecture10.repository

import edu.kcg.web3.lecture10.entity.ShopOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopOrderRepository : JpaRepository<ShopOrder, Long?>