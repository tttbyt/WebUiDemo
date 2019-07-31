package viettel.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="viettel.com")
public class WebUiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebUiDemoApplication.class, args);
	}

}
