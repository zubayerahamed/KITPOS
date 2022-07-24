package com.kit.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.pos.entity.Business;
import com.kit.pos.entity.pk.BusinessPK;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Repository
public interface BusinessRepository extends JpaRepository<Business, BusinessPK> {

}
