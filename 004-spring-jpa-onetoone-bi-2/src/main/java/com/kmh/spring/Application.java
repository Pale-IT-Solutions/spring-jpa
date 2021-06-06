package com.kmh.spring;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.kmh.spring.entity.OrderDetails;
import com.kmh.spring.entity.Orders;
import com.kmh.spring.repo.OrderDetialsRepo;
import com.kmh.spring.repo.OrdersRepo;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.kmh.spring.repo")
@EntityScan(basePackages = "com.kmh.spring.entity")
@ComponentScan(basePackages = "com.kmh.spring")
public class Application implements CommandLineRunner {

	@Autowired
	private OrdersRepo ordersRepo;

	@Autowired
	private OrderDetialsRepo detialsRepo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmSSS");
		LocalDateTime d = LocalDateTime.now();

		String orderNo = d.format(dtf);

		OrderDetails orderDetails = new OrderDetails();

		Orders order = new Orders();
		order.setOrderNo(orderNo);

		order.setOrderDetails(orderDetails);
		orderDetails.setOrder(order);

		this.ordersRepo.save(order);

		this.detialsRepo.save(orderDetails);

	}

}
