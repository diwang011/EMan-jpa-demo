package com.next.demo.bean;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "mouldType")
@Data
public class MouldType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "pId")
//	private MouldType parent;

	@Column(nullable = false)
	private String mouldTypeName;

	@Column(length = 2000)
	private String remark;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "pId") 
    @OrderColumn
	private Set<MouldType> children;
}
