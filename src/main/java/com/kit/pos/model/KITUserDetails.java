package com.kit.pos.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kit.pos.dto.response.BusinessResponseDTO;
import com.kit.pos.dto.response.UserAccountResponseDTO;
import com.kit.pos.enums.UserType;

/**
 * @author Zubayer Ahamed
 * @since Jul 24, 2022
 */
public class KITUserDetails implements UserDetails {

	private static final long serialVersionUID = 1606048816154494245L;

	private String name;
	private String username;
	private String password;
	private String businessId;
	private String division;
	private String shop;
	private String counter;
	private UserType userType;
	private boolean accountExpired;
	private boolean credentialExpired;
	private boolean accountLocked;
	private boolean enabled;
	private String roles;
	private List<GrantedAuthority> authorities;
	private BusinessResponseDTO business;

	public KITUserDetails(UserAccountResponseDTO user, BusinessResponseDTO business) {
		this.name = user.getName();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.businessId = user.getBusinessId();
		this.division = user.getDivision();
		this.shop = user.getShop();
		this.counter = user.getCounter();
		this.userType = user.getUserType();
		this.accountExpired = false;
		this.credentialExpired = false;
		this.accountLocked = false;
		this.enabled = user.getStatus() == 1;
		this.roles = user.getRoles();
		this.authorities = Arrays.stream(roles.split(","))
									.map(SimpleGrantedAuthority::new)
									.collect(Collectors.toList());
		this.business = business;
	}


	public String getName() {
		return name;
	}

	public String getBusinessId() {
		return businessId;
	}

	public String getDivision() {
		return division;
	}

	public String getShop() {
		return shop;
	}

	public String getCounter() {
		return counter;
	}

	public UserType getUserType() {
		return userType;
	}

	public String getRoles() {
		return roles;
	}

	public BusinessResponseDTO getBusiness() {
		return business;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !accountExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !accountLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !credentialExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
