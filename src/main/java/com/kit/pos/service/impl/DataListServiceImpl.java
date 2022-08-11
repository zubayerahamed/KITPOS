package com.kit.pos.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.pos.dto.request.DataListRequestDTO;
import com.kit.pos.dto.response.DataListResponseDTO;
import com.kit.pos.entity.DataList;
import com.kit.pos.entity.pk.DataListPK;
import com.kit.pos.repository.DataListRepository;
import com.kit.pos.service.DataListService;
import com.kit.pos.util.Response;

/**
 * @author Zubayer Ahamed
 * @since Aug 10, 2022
 */
@Service
public class DataListServiceImpl extends AbstractBaseService<DataListResponseDTO, DataListRequestDTO> implements DataListService<DataListResponseDTO, DataListRequestDTO>{

	@Autowired private DataListRepository dlRepo;

	@Override
	public Response<DataListResponseDTO> findByCodeAndActualValue(String code, String actualValue) {
		if(StringUtils.isBlank(code)) return getErrorResponse("Code required");
		if(StringUtils.isBlank(actualValue)) return getErrorResponse("Actual value required");
		Optional<DataList> d = dlRepo.findById(new DataListPK(appConfig.getBusinessId(), code.trim().toUpperCase(), actualValue));
		if(!d.isPresent()) return getErrorResponse("Found");
		return getSuccessResponse("Found", new DataListResponseDTO(d.get()));
	}

	@Override
	public Response<DataListResponseDTO> find(String id) {
		if(StringUtils.isBlank(id)) return getErrorResponse("Code required");
		List<DataList> list = dlRepo.findByCodeAndBusinessId(id.trim().toUpperCase(), appConfig.getBusinessId());
		if(list == null || list.isEmpty()) return getErrorResponse("Not found");
		return getSuccessResponse("Found", list.stream().map(d -> new ModelMapper().map(d, DataListResponseDTO.class)).collect(Collectors.toList()));
	}

	@Transactional
	@Override
	public Response<DataListResponseDTO> save(DataListRequestDTO reqDto) {
		if(StringUtils.isBlank(reqDto.getCode())) return getErrorResponse("Code required");
		if(StringUtils.isBlank(reqDto.getActualValue())) return getErrorResponse("Actual value required");

		Optional<DataList> d = dlRepo.findById(new DataListPK(appConfig.getBusinessId(), reqDto.getCode().trim().toUpperCase(), reqDto.getActualValue()));
		if(d.isPresent()) return getErrorResponse("Already exist");

		reqDto.setBusinessId(appConfig.getBusinessId());

		DataList dl = dlRepo.save(reqDto.getBean());
		if(dl == null) return getErrorResponse("Can't save");

		return getSuccessResponse("Saved", new DataListResponseDTO(dl));
	}

	@Transactional
	@Override
	public Response<DataListResponseDTO> update(DataListRequestDTO reqDto) {
		if(StringUtils.isBlank(reqDto.getCode())) return getErrorResponse("Code required");
		if(StringUtils.isBlank(reqDto.getActualValue())) return getErrorResponse("Actual value required");

		Optional<DataList> d = dlRepo.findById(new DataListPK(appConfig.getBusinessId(), reqDto.getCode().trim().toUpperCase(), reqDto.getActualValue()));
		if(!d.isPresent()) return getErrorResponse("Not found to do update");

		DataList dl = d.get();
		BeanUtils.copyProperties(reqDto, dl);
		dl.setBusinessId(appConfig.getBusinessId());
		dl = dlRepo.save(reqDto.getBean());
		if(dl == null) return getErrorResponse("Can't update");

		return getSuccessResponse("Update Successfully", new DataListResponseDTO(dl));
	}

	@Override
	public Response<DataListResponseDTO> getAll() {
		List<DataList> list = dlRepo.findAll();
		list.sort(Comparator.comparing(DataList::getCode).thenComparing(Comparator.comparing(DataList::getActualValue)));
		return getSuccessResponse("Found", list.stream().map(d -> new ModelMapper().map(d, DataListResponseDTO.class)).collect(Collectors.toList()));
	}

}
