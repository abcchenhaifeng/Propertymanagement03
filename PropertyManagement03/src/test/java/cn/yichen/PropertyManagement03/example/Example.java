package cn.yichen.PropertyManagement03.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @date: 2019年8月8日 下午3:27:10
 * @author YiChen(李冠永)
 * @Description: 第一次运行测试：OK( 2019年8月8日15:41:34 )
 *
 */
@EnableAutoConfiguration
@RestController
public class Example {

	@RequestMapping("/example/hello")
	public String hello() {
		return "Hello Property Mgt";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Example.class, args);
	}
}
