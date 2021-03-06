package io.spring.hellospringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
public class HelloSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApplication.class, args);
	}

}
//@RestController
//@Slf4j
//class HelloWorldController {
//	MeterRegistry meterRegistry;
//	@Value("${message:default message}")
//	String message;
//	public HelloWorldController(MeterRegistry meterRegistry) {
//		this.meterRegistry = meterRegistry;
//	}
//	@GetMapping("/hello")
//	public String helloworld() {
//		log.debug("Message: " + message);
//		meterRegistry.counter("helloworld.invoke.count").increment();
//		return message;
//	}
//}

@RestController
class HelloRestController {
    @Value("${message}")
    String message;
    @GetMapping("/hello")
    public String hello() {
        return message;
    }
}

@Service
class HelloWorldServiceHealthIndicator implements HealthIndicator {
	@Override
	public Health health() {
		return Health.up().withDetail("Service", "ok").build();
	}
}