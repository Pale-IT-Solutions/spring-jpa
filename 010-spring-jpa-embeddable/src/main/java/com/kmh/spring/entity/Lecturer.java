package com.kmh.spring.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "LECTURER")
public class Lecturer extends BaseEntity {

	@Column(name = "NAME")
	private String name;

	@Embedded
	private Address address;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Department.class)
	@JoinColumn
	private Department department;

}