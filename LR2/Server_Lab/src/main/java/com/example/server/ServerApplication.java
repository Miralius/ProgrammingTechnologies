package com.example.server;

import com.example.server.rmi.ImageWorker;
import com.example.server.rmi.ImageWorkerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;

import java.rmi.RemoteException;

@SpringBootApplication
public class ServerApplication{

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	RmiServiceExporter exporter(ImageWorker imageWorker) {
		Class<ImageWorker> serviceInterface = ImageWorker.class;
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setServiceInterface(serviceInterface);
		exporter.setService(imageWorker);
		exporter.setServiceName("ImageWorker");
		exporter.setRegistryPort(1099);
		return exporter;
	}

	@Bean
	ImageWorker imageWorkerService() throws RemoteException {
		return new ImageWorkerImpl();
	}
}