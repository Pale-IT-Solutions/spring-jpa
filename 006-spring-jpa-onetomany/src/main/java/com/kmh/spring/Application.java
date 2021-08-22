package com.kmh.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.kmh.spring.repo")
@ComponentScan(basePackages = "com.kmh.spring")
@EntityScan(basePackages = "com.kmh.spring.entity")
public class Application implements CommandLineRunner {

	@Autowired
	private DepartmentRepo deptRepo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		this.addDept();

	}

	private void addDept() {

		UUID uuid = UUID.randomUUID();
		String deptName = "Dept " + uuid.toString();

		Department dept = new Department();
		dept.setName(deptName);

		List<Student> students = getStudents(2);
		dept.setStudents(students);

		this.deptRepo.save(dept);
	}

	private List<Student> getStudents(int count) {

		List<Student> list = new ArrayList<Student>();

		for (int i = 0; i < count; i++) {

			Student student = new Student();
			student.setName("Student " + UUID.randomUUID().toString());

			list.add(student);
		}

		return list;
	}

}
