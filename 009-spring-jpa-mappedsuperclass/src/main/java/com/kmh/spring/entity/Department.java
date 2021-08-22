package com.kmh.spring.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "DEPARTMENT")
public class Department extends BaseEntity {

	@Column(name = "NAME", unique = true)
	private String name;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY, targetEntity = Student.class)
	private List<Student> students;

}