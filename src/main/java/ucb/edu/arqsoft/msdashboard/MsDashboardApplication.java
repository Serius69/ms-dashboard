package ucb.edu.arqsoft.msdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MsDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDashboardApplication.class, args);
	}

}
