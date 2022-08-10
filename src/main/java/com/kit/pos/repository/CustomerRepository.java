package com.kit.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.pos.entity.Customer;
import com.kit.pos.entity.pk.CustomerPK;

/**
 * @author Zubayer Ahamed
 * @since Aug 8, 2022
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, CustomerPK> {

	Customer findTopByOrderByCustomerIdDesc();
}
