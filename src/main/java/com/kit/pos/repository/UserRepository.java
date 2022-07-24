package com.kit.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.pos.entity.User;
import com.kit.pos.entity.pk.UserPK;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
@Repository
public interface UserRepository extends JpaRepository<User, UserPK>{

}
