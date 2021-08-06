package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




import com.example.dao.AAAMapper;

@RestController
public class MyController {
	
	@Autowired
	AAAMapper aAAMapper;
	
	
	@Autowired
	@Qualifier("hpPrinter")
	private Printer printer;
	
	@RequestMapping("/product")
	public Store product() {
		//printer.print("Hello World");
		Store store = new Store();
		List<String> list = new ArrayList<String>();
		list.add("蘋果");
		list.add("橘子");
		store.setProductList(list);
		return store;
	}
	
	@RequestMapping("/user")
	public Student user() {
		Student student = new Student();
		student.setName("帥哥");
		return student;
	}
	
	@RequestMapping("/test1")
	public String test1(@RequestParam Integer id,
						@RequestParam String name) {		
		System.out.println("id : " + id);
		System.out.println("name : " + name);
		return "Hello test1";		
	}
	
	@RequestMapping("/test2")
	public String test2(@RequestBody @Valid Student student) {
		
		System.out.println("student id : " + student.getId());
		System.out.println("student name : " + student.getName());
		return "Hello test2";		
	}
	
	@RequestMapping("/test3")
	public ResponseEntity<String> test3(@RequestHeader String info) {
		System.out.println("header info : " + info);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello test3");
		//return "Hello test3";		
	}
	
	@RequestMapping("/test4/{id}/{name}")
	public String test4(@PathVariable Integer id,
						@PathVariable String name) {
		System.out.println("path id : " + id);
		System.out.println("path name : " + name);
		return "Hello test4";		
	}
	
	@RequestMapping("/testException")
	public String testException() {
		throw new RuntimeException("錯囉");
	}
	
	@RequestMapping("/testInterceptor")
	public String testInterceptor() {
		System.out.println("執行 testInterceptor");
		return "Hello testInterceptor!!";
	}
	
	@RequestMapping("/testDao")
	public String testDao() {
		
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		List<Object> t = new ArrayList<Object>();
		dataList = aAAMapper.select(null);
		
		for (Map<String, Object> s : dataList) {
			for (Object key : s.keySet()) {
	            t.add(s.get(key));
	        }
        }
		
		return dataList.toString();
	}
	

}
