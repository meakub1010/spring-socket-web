package my.project.spring_socket_react;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringSocketReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSocketReactApplication.class, args);
	}

}
