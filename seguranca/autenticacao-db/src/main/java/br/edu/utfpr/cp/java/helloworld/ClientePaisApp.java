package br.edu.utfpr.cp.java.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableWebSecurity
public class ClientePaisApp extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/admin").hasAuthority("admin")
				.antMatchers("/user").hasAnyAuthority("user")
				.antMatchers("/private").fullyAuthenticated()
				.antMatchers("/public").permitAll()
				.antMatchers("/login*").permitAll()
				.antMatchers("/logout*").permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/login.html")
				.defaultSuccessUrl("/pais", false)
			.and()
				.logout();
	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientePaisApp.class, args);
	}

	// @EventListener(ApplicationReadyEvent.class)
	// public void init() {
	// System.out.println(new BCryptPasswordEncoder().encode("doe"));
	// System.out.println(new BCryptPasswordEncoder().encode("doedoe"));
	// }
}
