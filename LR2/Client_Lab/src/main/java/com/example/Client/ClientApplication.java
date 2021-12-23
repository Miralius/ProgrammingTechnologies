package com.example.Client;

import com.example.Client.Service.ImageWorkerService;
import com.example.Client.rmi.ImageWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@SpringBootApplication
public class ClientApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		ImageWorker service = SpringApplication.run(ClientApplication.class, args).getBean(ImageWorker.class);
		ImageWorkerService.setImageWorker(service);
	}

	@Bean
	RmiProxyFactoryBean service() {
		RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
		rmiProxyFactory.setServiceUrl("rmi://localhost:1099/ImageWorker");
		rmiProxyFactory.setServiceInterface(ImageWorker.class);
		return rmiProxyFactory;
	}
}
