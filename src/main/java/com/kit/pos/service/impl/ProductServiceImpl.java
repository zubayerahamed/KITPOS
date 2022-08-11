package com.kit.pos.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.pos.dto.request.ProductRequestDTO;
import com.kit.pos.dto.response.ProductResponseDTO;
import com.kit.pos.entity.Category;
import com.kit.pos.entity.DataList;
import com.kit.pos.entity.Product;
import com.kit.pos.entity.pk.CategoryPK;
import com.kit.pos.entity.pk.ProductPK;
import com.kit.pos.enums.DiscountType;
import com.kit.pos.repository.CategoryRepository;
import com.kit.pos.repository.DataListRepository;
import com.kit.pos.repository.ProductRepository;
import com.kit.pos.service.ProductService;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 8, 2022
 */
@Service
public class ProductServiceImpl extends AbstractBaseService<ProductResponseDTO, ProductRequestDTO> implements ProductService<ProductResponseDTO, ProductRequestDTO>{

	@Autowired private ProductRepository productRepository;
	@Autowired private CategoryRepository categoryRepo;
	@Autowired private DataListRepository dataListRepo;

	@Override
	public Response<ProductResponseDTO> find(String id) {
		if(StringUtils.isBlank(id)) return getErrorResponse("Id required");

		Optional<Product> product = productRepository.findById(new ProductPK(appConfig.getBusinessId(), id));
		if(!product.isPresent()) return getErrorResponse("Product not found");

		return getSuccessResponse(null, "Product found", new ProductResponseDTO(product.get()));
	}

	@Override
	public Response<ProductResponseDTO> save(ProductRequestDTO reqDto) {
		if(reqDto == null) return getErrorResponse("Data required to do save");
		// validation
		// check category exist??
		if(StringUtils.isBlank(reqDto.getCategoryId())) return getErrorResponse("Category required");
		Optional<Category> category = categoryRepo.findById(new CategoryPK(appConfig.getBusinessId(), reqDto.getCategoryId()));
		if(!category.isPresent()) return getErrorResponse("Invalid category selected");

		if(reqDto.getProductGroup() == null) return getErrorResponse("Product group required");

		if(reqDto.getRate() == null) return getErrorResponse("Rate required");
		if(reqDto.getRate().compareTo((BigDecimal.ZERO)) == -1) return getErrorResponse("Invalid rate");

		List<DataList> uomList = dataListRepo.findByCodeAndBusinessId("UOM", appConfig.getBusinessId());
		if(uomList == null || uomList.isEmpty()) return getErrorResponse("System doesn't have any unit of meserment declaration");
		List<String> uoms = uomList.stream().map(DataList::getActualValue).collect(Collectors.toList());

		if(StringUtils.isBlank(reqDto.getSellUom())) {
			return getErrorResponse("Selling unit required");
		} else {
			if(!uoms.contains(reqDto.getSellUom())) return getErrorResponse("Invalid selling unit");
		}
		if(appConfig.isActiveInventory() && StringUtils.isBlank(reqDto.getStockUom())) {
			return getErrorResponse("Stock unit required");
		} else {
			if(!uoms.contains(reqDto.getStockUom())) return getErrorResponse("Invalid stock unit");
		}
		if(appConfig.isActiveInventory() && StringUtils.isBlank(reqDto.getPurchaseUom())) {
			return getErrorResponse("Purchse unit required"); 
		} else {
			if(!uoms.contains(reqDto.getPurchaseUom())) return getErrorResponse("Invalid purchase unit");
		}

		if(reqDto.getDiscountType() != null) {
			if(reqDto.getDiscountType().equals(DiscountType.FLAT)) {
				if(reqDto.getDiscountAmount() == null || reqDto.getDiscountAmount().compareTo(BigDecimal.ZERO) == -1) return getErrorResponse("Invalid discount amount");
			} else {
				if((reqDto.getDiscountRate() == null || reqDto.getDiscountRate().compareTo(BigDecimal.ZERO) == -1)) return getErrorResponse("Invalid discount rate");
			}
		}

		if(reqDto.getVatRate() != null && reqDto.getVatRate().compareTo(BigDecimal.ZERO) == -1) return getErrorResponse("Invalid vat rate");
		if(reqDto.getSuppDutyRate() != null && reqDto.getSuppDutyRate().compareTo(BigDecimal.ZERO) == -1) return getErrorResponse("Invalid supplimentory rate");

		if(reqDto.isSetMenu()) {
			if(reqDto.isSetItem()) return getErrorResponse("Set menu can't be a set item");
			if(reqDto.isAddOnItem()) return getErrorResponse("Set menu can't be a addon item");
		}

		// create id
		Product p = reqDto.getBean();
		p.setProductId(idGenerator.getNewProductId());
		p.setBusinessId(appConfig.getBusinessId());
		p.setVatAmt((p.getRate().multiply(p.getVatRate()).divide(BigDecimal.valueOf(100))));
		p.setSuppDutyAmt((p.getRate().multiply(p.getSuppDutyRate()).divide(BigDecimal.valueOf(100))));
		if(DiscountType.PERCENT.equals(p.getDiscountType())) {
			p.setDiscountAmount((p.getRate().multiply(p.getDiscountRate())).divide(BigDecimal.valueOf(100)));
		}
		p = productRepository.save(p);
		if(p == null) return getErrorResponse("Can't save product");

		return getSuccessResponse(null, "Product saved successfully", new ProductResponseDTO(p));
	}

	@Override
	public Response<ProductResponseDTO> update(ProductRequestDTO reqDto) {
		if(reqDto == null) return getErrorResponse("Data required to do update");

		// validation
		if(StringUtils.isBlank(reqDto.getProductId())) return getErrorResponse("Id required");

		// check existing
		Optional<Product> exProduct = productRepository.findById(new ProductPK(appConfig.getBusinessId(), reqDto.getProductId()));
		if(!exProduct.isPresent()) return getErrorResponse("Product not found");

		Product p = exProduct.get();
		BeanUtils.copyProperties(reqDto, p);

		p = productRepository.save(p);
		if(p == null) return getErrorResponse("Can't update product");

		return getSuccessResponse(null, "Product updated successfully", new ProductResponseDTO(p));
	}

	@Override
	public Response<ProductResponseDTO> getAll() {
		List<Product> list = productRepository.findAll();
		if(list == null || list.isEmpty()) return getErrorResponse("No Product found");

		List<ProductResponseDTO> response = list.stream().map(data -> new ModelMapper().map(data, ProductResponseDTO.class)).collect(Collectors.toList());
		return getSuccessResponse(null, "Found products", response);
	}


}
