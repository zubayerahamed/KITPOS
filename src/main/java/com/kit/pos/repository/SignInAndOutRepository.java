package com.kit.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.pos.entity.SignInAndOut;
import com.kit.pos.entity.pk.SignInAndOutPK;

/**
 * @author Zubayer Ahamed
 * @since Aug 15, 2022
 */
@Repository
public interface SignInAndOutRepository extends JpaRepository<SignInAndOut, SignInAndOutPK>{

}
