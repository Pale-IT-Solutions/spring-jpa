package com.kmh.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ORDER_DETAILS")
@Getter
@Setter
@NoArgsConstructor
public class OrderDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_DETAILS_ID")
	private Integer orderDetailsId;

	@Column(name = "ORDERED_DATE")
	private Date orderedDate;

	@Column(name = "SHIPPING_DATE")
	private Date shippingDate;

	@Column(name = "SHIPPING_ADDRESS")
	private String shippingAddress;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DELIVERY_DATE")
	private Date deliveryDate;

	@Column(name = "CREATED_USER")
	private String createdUser = "SYSTEM USER";;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE")
	private Date createdDate = new Date();

	@Column(name = "MODIFIED_USER")
	private String modifiedUser = "SYSTEM USER";;

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate = new Date();

	@OneToOne
	@JoinTable(name = "MY_JOIN_TABLE", joinColumns = { @JoinColumn(name = "ORDER_DETAILS_FK", referencedColumnName = "ORDER_DETAILS_ID") }, inverseJoinColumns = { @JoinColumn(name = "ORDERS_FK", referencedColumnName = "ORDERS_ID", unique = true) })
	private Orders order;
}
