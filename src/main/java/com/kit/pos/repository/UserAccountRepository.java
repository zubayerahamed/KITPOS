package com.kit.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.pos.entity.UserAccount;
import com.kit.pos.entity.pk.UserAccountPK;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, UserAccountPK>{

}
