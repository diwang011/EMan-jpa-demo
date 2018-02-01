package com.next.demo.service;



import com.next.demo.bean.MouldType;

public interface MouldTypeService {

	MouldType findAll();

	MouldType save(MouldType mouldType);

	Boolean del(Integer mouldTypeId);

}
