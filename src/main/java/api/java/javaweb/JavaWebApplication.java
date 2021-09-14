package api.java.javaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaWebApplication {


	public static void main(String[] args) {
		System.out.println("JAVA BACKEND --- START");

		SpringApplication.run(JavaWebApplication.class, args);

		System.out.println("JAVA BACKEND --- END");
	}

}
