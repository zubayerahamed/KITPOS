package com.kit.pos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.pos.entity.DataList;
import com.kit.pos.entity.pk.DataListPK;

/**
 * @author Zubayer Ahamed
 * @since Aug 10, 2022
 */
@Repository
public interface DataListRepository extends JpaRepository<DataList, DataListPK>{

	public List<DataList> findByCodeAndBusinessId(String code, String businessId);


}
