package com.kmh.spring.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Address {

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
}