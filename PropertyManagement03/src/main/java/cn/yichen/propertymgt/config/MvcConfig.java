package cn.yichen.propertymgt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * @date: 2019年8月12日 下午5:11:11
 * @author: YiChen(李冠永)
 * @Description: Spring MVC DispatcherServlet级别的IoC容器配置类
 *
 */
@Configuration
// 启用MVC注解类解析
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	// 配置全局CORS
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
	}
}
