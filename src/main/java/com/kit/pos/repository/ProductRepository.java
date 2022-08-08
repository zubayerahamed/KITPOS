package com.kit.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.pos.entity.Product;
import com.kit.pos.entity.pk.ProductPK;

/**
 * @author Zubayer Ahamed
 * @since Aug 8, 2022
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, ProductPK> {

}
