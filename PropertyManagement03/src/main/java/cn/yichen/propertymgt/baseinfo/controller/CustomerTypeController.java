package cn.yichen.propertymgt.baseinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import cn.yichen.propertymgt.baseinfo.model.CustomerType;
import cn.yichen.propertymgt.baseinfo.service.impl.CustomerTypeServiceImpl;



/**
 * @date:2019年8月9日 下午1:40:27
 * @author LiYi(李海宏）
 * @description:
 */


@RestController
@RequestMapping("/customertype")
@EnableWebMvc
@CrossOrigin
public class CustomerTypeController {

	
	@Autowired
	private CustomerTypeServiceImpl service;
	
	
	@GetMapping(value="/list/all")
	public List<CustomerType> getListByAllandType() throws Exception{
		
		return service.getListByAll();
	}
	
}
