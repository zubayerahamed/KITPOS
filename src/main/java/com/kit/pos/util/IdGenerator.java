package com.kit.pos.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kit.pos.config.AppConfig;
import com.kit.pos.entity.Customer;
import com.kit.pos.entity.Product;
import com.kit.pos.entity.SignInAndOut;
import com.kit.pos.repository.CustomerRepository;
import com.kit.pos.repository.ProductRepository;
import com.kit.pos.repository.SignInAndOutRepository;

/**
 * @author Zubayer Ahamed
 * @since Aug 8, 2022
 */
@Component
public class IdGenerator {

	@Autowired private AppConfig appConfig;
	@Autowired private ProductRepository productRepo;
	@Autowired private CustomerRepository customerRepo;
	@Autowired private SignInAndOutRepository signInAndOutRepo;

	/**
	 * Generate new product id 
	 * @return productId
	 */
	public String getNewProductId() {
		String id = null;
		Product p = productRepo.findTopByOrderByProductIdDesc();
		if(p != null) {
			id = p.getProductId();
		}

		String prefix = "IC--";
		int suffix = 10000;
		if (!StringUtils.isBlank(id)) {
			final String lastFourDigits = id.substring(id.length() - 5);
			suffix = Integer.parseInt(lastFourDigits);
		}

		suffix++;
		return prefix + appConfig.getDivision() + appConfig.getShop() + suffix;
	}

	/**
	 * Generate New Customer ID
	 * @return
	 */
	public String getNewCustomerId() {
		String id = null;
		Customer c = customerRepo.findTopByOrderByCustomerIdDesc();

		if(c != null) {
			id = c.getCustomerId();
		}

		String prefix = "CUS-";
		int suffix = 10000;
		if (!StringUtils.isBlank(id)) {
			final String lastFourDigits = id.substring(id.length() - 5);
			suffix = Integer.parseInt(lastFourDigits);
		}

		suffix++;
		return prefix + appConfig.getDivision() + appConfig.getShop() + suffix;
	}

	/**
	 * Generate new Sign In And Out ID
	 * @return
	 */
	public String getNewSignInAndOutId() {
		String id = null;
		SignInAndOut s = signInAndOutRepo.findTopByOrderByRowIdDesc();

		if(s != null) {
			id = s.getRowId();
		}

		int suffix = 0;
		if (!StringUtils.isBlank(id)) {
			suffix = Integer.parseInt(id);
		}

		suffix++;
		return String.valueOf(suffix);
	}
}
