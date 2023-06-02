package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.other.User;
import com.fasterxml.jackson.annotation.JsonGetter;

@SpringBootApplication
@RestController
public class TestApplication {
    
	/** 
	 * @param args
	 */
	public static void main(String[] args) {
      SpringApplication.run(TestApplication.class, args);
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        User  user = new User();
        user.setName(name);

      return String.format("Hello %s!", user.getName());
    }
}
