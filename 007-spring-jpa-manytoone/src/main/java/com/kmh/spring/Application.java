package com.kmh.spring;

import java.util.UUID;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.kmh.spring.entity.Department;
import com.kmh.spring.entity.Student;
import com.kmh.spring.repo.DepartmentRepo;
import com.kmh.spring.repo.StudentRepo;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.kmh.spring.repo")
@ComponentScan(basePackages = "com.kmh.spring")
@EntityScan(basePackages = "com.kmh.spring.entity")
public class Application implements CommandLineRunner {

	@Autowired
	private DepartmentRepo deptRepo;

	@Autowired
	private StudentRepo studentRepo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		this.addDept();

		this.addStudent();

	}

	private void addDept() {

		UUID uuid = UUID.randomUUID();
		String deptName = "Dept " + uuid.toString();

		Department dept = new Department();
		dept.setName(deptName);

		this.deptRepo.save(dept);
		
	}

	private void addStudent() throws NoResultException {

		Department dept = this.deptRepo.findById(1).orElse(null);
		if (null == dept) {
			throw new NoResultException();
		}

		Student student = new Student();
		student.setName("Student " + UUID.randomUUID().toString());
		student.setDepartment(dept);

		this.studentRepo.save(student);

	}

}
