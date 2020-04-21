package cr.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("cr.ms")
public class ManagerSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerSysApplication.class, args);
	}

}
