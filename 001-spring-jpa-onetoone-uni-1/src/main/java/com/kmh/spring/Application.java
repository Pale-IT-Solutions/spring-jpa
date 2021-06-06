package com.kmh.spring;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.datetime.DateFormatter;
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

		Orders order = new Orders();
		order.setOrderNo(orderNo);
//		this.ordersRepo.save(order);

		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setOrders(order);

		this.detialsRepo.save(orderDetails);

		OrderDetails de = this.detialsRepo.findAllById(1);
		de.setDeliveryDate(new Date());
		de.getOrders().setOrderNo("yyyyMMddHHmmSSS");
		this.detialsRepo.save(de);
	}

}
