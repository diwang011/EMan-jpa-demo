package com.next.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.next.demo.bean.MouldType;
import com.next.demo.service.MouldTypeService;

@RestController
@RequestMapping(value = "/mouldType")
public class MouldTypeController {
	@Autowired
	private MouldTypeService mouldTypeService;

	@RequestMapping(value = "/search")
	public @ResponseBody MouldType search() {
		return mouldTypeService.findAll();
	}

	@RequestMapping(value = "/save")
	public @ResponseBody MouldType save(@RequestBody BaseRequest<MouldType> request) {
		MouldType mouldType = request.getData();
		return mouldTypeService.save(mouldType);
	}

	@RequestMapping(value = "/del")
	public @ResponseBody Boolean del(@RequestBody BaseRequest<Integer> request) {
		Integer mouldTypeId = request.getData();
		return mouldTypeService.del(mouldTypeId);
	}
}
