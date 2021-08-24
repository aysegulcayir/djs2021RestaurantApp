package com.restaurant.reservationApp;

//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoDatabase;
import com.restaurant.reservationApp.employee.Employee;
import com.restaurant.reservationApp.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication


public class RestaurantAppApplication implements CommandLineRunner {

@Autowired
	EmployeeService employeeService;
	public static void main(String[] args) {

		SpringApplication.run(RestaurantAppApplication.class, args);
//		try {
//			MongoClient mongoClient = MongoClients.create(
//					"mongodb+srv://Aysegul:1234@cluster0.xxspu.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
//			MongoDatabase database = mongoClient.getDatabase("test");
//			System.out.println("connection is ready");
//
//		}catch (Error e){}

	}


	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee("aaaa","Ibrahim","a","12345");
		this.employeeService.createEmployee(employee);
	}
}
