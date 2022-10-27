package mysecurity.security1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController

public class Security1Application {
//extends WebSecurityConfigurerAdapter {
public static void main(String[] args) {
		SpringApplication.run(Security1Application.class, args);
	}
	
	@RequestMapping("/")
	public String takethis() {
		
		return "epa is my bow ";
	}
	
	
	@RequestMapping("/user")
	public String user() {
		
		return "this is user api";
	}	
	
	
	@RequestMapping("/epa")
	public String admin() {
		
		return "this is admin api";
	}
	
	
	
/*	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("omar").password("omar").roles("omar");
	}
	

	@Bean
	public PasswordEncoder setencoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
	*/
}
