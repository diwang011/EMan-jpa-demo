package com.next.demo.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.next.demo.bean.MouldType;
import com.next.demo.repository.MouldTypeRepository;
import com.next.demo.service.MouldTypeService;

@Service
@Transactional
public class MouldTypeServiceImpl implements MouldTypeService {
	@Autowired
	private MouldTypeRepository mouldTypeRepository;

	@Override
	public MouldType findAll() {
		MouldType  mouldTypes=mouldTypeRepository.findOne(1);
		System.out.println(JSON.toJSONString(mouldTypes));
		return mouldTypes;
	}

	@Override
	public MouldType save(MouldType mouldType) {
		return mouldTypeRepository.save(mouldType);
	}

	@Override
	public Boolean del(Integer mouldTypeId) {
		try {
			mouldTypeRepository.delete(mouldTypeId);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
