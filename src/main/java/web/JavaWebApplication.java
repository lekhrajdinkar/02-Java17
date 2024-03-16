package web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class JavaWebApplication {


	public static void main(String[] args) {
		System.out.println("JAVA BACKEND --- START");

		SpringApplication.run(JavaWebApplication.class, args);

		System.out.println("JAVA BACKEND --- END");
	}

}
