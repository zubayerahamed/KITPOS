package com.kit.pos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.pos.entity.Category;
import com.kit.pos.entity.pk.CategoryPK;

/**
 * @author Zubayer Ahamed
 * @since Aug 4, 2022
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, CategoryPK> {

	List<Category> findByParentCategoryAndBusinessId(String parentCategory, String businessId);
}
