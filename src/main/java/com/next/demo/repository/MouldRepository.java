package com.next.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.next.demo.bean.Mould;

public interface MouldRepository extends JpaRepository<Mould, Integer>, JpaSpecificationExecutor<Mould> {

}
