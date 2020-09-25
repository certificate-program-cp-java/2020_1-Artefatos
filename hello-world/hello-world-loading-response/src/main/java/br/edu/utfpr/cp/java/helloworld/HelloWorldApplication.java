package br.edu.utfpr.cp.java.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	@GetMapping ("/hello")
	@ResponseBody
	public String sayHello() {
		// return "Hello World!!!";
		return "<h1>Hello World!!!</h1>";
	}

	@PostMapping ("/hello/form")
	@ResponseBody
	public String resultado() {
		return "Dados recebidos!";
	}
}

