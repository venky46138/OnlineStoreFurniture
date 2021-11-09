package com.repositry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Bill;
@Repository

public interface BillRepository extends JpaRepository<Bill,Long>{
	@Query(nativeQuery = true, value = "SELECT b.bill_no AS billNo,* FROM BILL b WHERE b.customer_name = :customerName")
    Bill findByCustomer(@Param("customerName") String customerName);

}
