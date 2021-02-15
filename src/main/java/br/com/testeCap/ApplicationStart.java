package br.com.testeCap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("br.com.testeCap")
public class ApplicationStart  {
	
	// classe que inicia a aplicacao

  public static void main(String[] args) {
    SpringApplication.run(ApplicationStart.class, args);
  }
}

