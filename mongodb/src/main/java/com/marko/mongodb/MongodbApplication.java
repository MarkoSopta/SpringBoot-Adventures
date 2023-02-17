package com.marko.mongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class MongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(StudentRepository repository, MongoTemplate mongoTemplate){
		return args -> {
			Address address = new Address("bih","starmo","88000");
		Student student = new Student("ime",
				"prezime",
				"gmail@gmail.com", Gender.Male,address,
				List.of("Comp sci","Math","English"),
				BigDecimal.TEN,
				LocalDateTime.now()
				);

		Query query =new Query();
		query.addCriteria(Criteria.where("email").is("gmail@gmail.com"));
		List<Student> students= mongoTemplate.find(query, Student.class);

			if(students.size()>1){
				throw new IllegalStateException("Found many students with the same email");
			}

			if(students.isEmpty()){
				System.out.println("inserting");
				repository.insert(student);
			}else {
				System.out.println("student already exists");
			}

		};
	}
}
