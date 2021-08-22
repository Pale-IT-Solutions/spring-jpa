package com.kmh.spring.entity;

import javax.persistence.Column;
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
@Table(name = "STUDENT")
public class Student extends BaseEntity {

	@Column(name = "NAME")
	private String name;

	@Column(name = "POSTALCODE")
	private String postalcode;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "CITY")
	private String city;

	@Column(name = "PREFECTURE")
	private String prefecture;

	@Column(name = "STREET")
	private String street;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Department.class)
	@JoinColumn
	private Department department;

}