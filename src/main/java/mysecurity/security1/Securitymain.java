package mysecurity.security1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Securitymain extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {

		SpringApplication.run(Securitymain.class, args);

	}
	
	

	
@Override
protected void  configure(AuthenticationManagerBuilder mb) throws Exception {
		
mb.inMemoryAuthentication().withUser("url1").password("url1").roles("parvez");
mb.inMemoryAuthentication().withUser("url2").password("url2").roles("chadni");
mb.inMemoryAuthentication().withUser("url3").password("url3").roles("batol");

	}
	
	
@Bean
	public PasswordEncoder getb() throws Exception {
		
return NoOpPasswordEncoder.getInstance();
		
	}
	

@Override
protected void  configure(HttpSecurity http) throws Exception {
http.authorizeRequests().antMatchers("/parvez").hasRole("parvez").and().formLogin();
http.authorizeRequests().antMatchers("/chadni").hasAnyRole("chadni","parvez").and().formLogin();
http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/batol").hasAnyRole("batol","parvez").and().formLogin();


	}



	
@RequestMapping("/")
	public String getindex() {
		
		return "this is from index page";
		
	}
	
	
	
	@RequestMapping("/parvez")
	public String getindex1() {
		
		
		return "this is url one";
		
	}
		
	
	
	@RequestMapping("/chadni")
	public String getindex2() {
		
		return "this is url two";
		
	}
	
		
	@RequestMapping("/batol")
	public String getindex3() {
		
		return "this is url three";
		
		
	}
			
	

}
