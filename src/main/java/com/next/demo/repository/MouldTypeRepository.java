package com.next.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.next.demo.bean.MouldType;

public interface MouldTypeRepository extends JpaRepository<MouldType, Integer>, JpaSpecificationExecutor<MouldType> {

}
