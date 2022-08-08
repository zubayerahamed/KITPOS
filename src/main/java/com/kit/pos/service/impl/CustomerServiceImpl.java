package com.kit.pos.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.pos.dto.request.CustomerRequestDTO;
import com.kit.pos.dto.response.CustomerResponseDTO;
import com.kit.pos.entity.Customer;
import com.kit.pos.entity.pk.CustomerPK;
import com.kit.pos.repository.CustomerRepository;
import com.kit.pos.service.CustomerService;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 8, 2022
 */
@Service
public class CustomerServiceImpl extends AbstractBaseService<CustomerResponseDTO, CustomerRequestDTO> implements CustomerService<CustomerResponseDTO, CustomerRequestDTO> {

	@Autowired private CustomerRepository customerRepository;

	@Override
	public Response<CustomerResponseDTO> find(String id) {
		if(StringUtils.isBlank(id)) return getErrorResponse("Id required");

		Optional<Customer> customer = customerRepository.findById(new CustomerPK(appConfig.getBusinessId(), id));
		if(!customer.isPresent()) return getErrorResponse("Customer not found");

		return getSuccessResponse(null, "Customer found", new CustomerResponseDTO(customer.get()));
	}

	@Transactional
	@Override
	public Response<CustomerResponseDTO> save(CustomerRequestDTO reqDto) {
		if(reqDto == null) return getErrorResponse("Data required");

		Customer c = customerRepository.save(reqDto.getBean());
		if(c == null) return getErrorResponse("Can't save Customer");

		return getSuccessResponse(null, "", new CustomerResponseDTO(c)); 
	}

	@Transactional
	@Override
	public Response<CustomerResponseDTO> update(CustomerRequestDTO reqDto) {
		if(reqDto == null) return getErrorResponse("Data required");

		// validation
		if(StringUtils.isBlank(reqDto.getCustomerId())) return getErrorResponse("Id required");

		Optional<Customer> customer = customerRepository.findById(new CustomerPK(appConfig.getBusinessId(), reqDto.getCustomerId()));
		if(!customer.isPresent()) return getErrorResponse("Customer not found");

		Customer c = customer.get();
		BeanUtils.copyProperties(reqDto, c);
		c = customerRepository.save(c);
		if(c == null) return getErrorResponse("Can't update Customer");

		return getSuccessResponse(null, "", new CustomerResponseDTO(c)); 
	}

	@Override
	public Response<CustomerResponseDTO> getAll() {
		List<Customer> customers = customerRepository.findAll();
		if(customers == null || customers.isEmpty()) return getErrorResponse("No customers found");

		List<CustomerResponseDTO> list = customers.stream().map(data -> new ModelMapper().map(data, CustomerResponseDTO.class)).collect(Collectors.toList());
		return getSuccessResponse(null, "Customers list found", list);
	}

}
