package com.next.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.next.demo.bean.Mould;
import com.next.demo.bean.User;
import com.next.demo.service.MouldService;

@RestController
@RequestMapping(value = "/mould")
public class MouldController {
	@Autowired
	private MouldService mouldService;

	@RequestMapping(value = "/search")
	public @ResponseBody Page<Mould> search(@RequestBody BaseRequest<String> request,
			@SessionAttribute User user) {
		return mouldService.findAll(request,user);
	}

	@RequestMapping(value = "/save")
	public @ResponseBody Mould save(@RequestBody BaseRequest<Mould> request) {
		Mould mould = request.getData();
		return mouldService.save(mould);
	}

	@RequestMapping(value = "/del")
	public @ResponseBody Boolean del(@RequestBody BaseRequest<Integer> request) {
		Integer mouldId = request.getData();
		return mouldService.del(mouldId);
	}

	@RequestMapping(value = "/searchMouldName")
	public @ResponseBody List<String> searchMouldName(@RequestBody BaseRequest<String> request) {
		String mouldName = request.getData();
		return mouldService.searchMouldName(mouldName);
	}
}
