package com.next.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.next.demo.bean.Mould;
import com.next.demo.bean.User;
import com.next.demo.controller.BaseRequest;
import com.next.demo.repository.MouldRepository;
import com.next.demo.service.MouldService;

@Service
@Transactional
public class MouldServiceImpl implements MouldService {
	@Autowired
	private MouldRepository mouldRepository;

	@Override
	public Page<Mould> findAll(BaseRequest<String> request, User user) {
		PageRequest page = new PageRequest(request.getPageNumber(), request.getPageSize());
		Mould probe = new Mould();
		if (StringUtils.isNotEmpty(request.getData())) {
			probe.setMouldName(request.getData());
		}
		User u=new User();
		u.setId(user.getId());
		probe.setUser(u);
		Example<Mould> example = Example.of(probe);
		Page<Mould> list = mouldRepository.findAll(example, page);
		System.out.println("--------------" + JSON.toJSONString(list));
		return list;
	}

	@Override
	public Mould save(Mould mould) {
		return mouldRepository.save(mould);
	}

	@Override
	public Boolean del(Integer mouldId) {
		try {
			mouldRepository.delete(mouldId);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<String> searchMouldName(String mouldName) {
		List<String> list = new ArrayList<>();
		List<Mould> moulds = mouldRepository.findAll();
		for (Mould mould : moulds) {
			if (mould.getMouldName().indexOf(mouldName) != -1) {
				list.add(mould.getMouldName());
			}
		}
		return list;
	}
}
