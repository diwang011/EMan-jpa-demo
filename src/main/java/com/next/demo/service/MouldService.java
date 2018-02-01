package com.next.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.next.demo.bean.Mould;
import com.next.demo.bean.User;
import com.next.demo.controller.BaseRequest;

public interface MouldService {

	Page<Mould> findAll(BaseRequest<String> request, User user);

	Mould save(Mould mould);

	Boolean del(Integer mouldId);

	List<String> searchMouldName(String mouldName);

}
