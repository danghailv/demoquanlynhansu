package com.example.employee_manager;

import com.example.employee_manager.entity.Department;
import com.example.employee_manager.entity.Employee;
import com.example.employee_manager.repository.DepartmentRepository;
import com.example.employee_manager.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@SpringBootApplication
public class EmployeeManagerApplication {


	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagerApplication.class, args);



	}

	@Bean
	CommandLineRunner commandLineRunner(DepartmentRepository departmentRepository){
		return args -> {
			//departmentRepository.save(new Department("Phòng nhân s", (byte) 4,new ArrayList<>()));
			//System.out.println("12321321312");
			//System.out.println(Calendar.getInstance().getTime().toString());

		};
	}

}
