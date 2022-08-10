package com.kit.pos.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.pos.dto.request.DataListRequestDTO;
import com.kit.pos.dto.response.DataListResponseDTO;
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
	public Response<DataListResponseDTO> find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Response<DataListResponseDTO> save(DataListRequestDTO reqDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Response<DataListResponseDTO> update(DataListRequestDTO reqDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<DataListResponseDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
