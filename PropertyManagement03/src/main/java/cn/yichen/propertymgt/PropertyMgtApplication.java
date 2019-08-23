package cn.yichen.propertymgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient // 启用注册客户端
@EnableHystrix // 启用熔断器保护
public class PropertyMgtApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyMgtApplication.class, args);
	}
}
