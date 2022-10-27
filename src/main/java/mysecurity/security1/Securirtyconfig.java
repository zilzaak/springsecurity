package mysecurity.security1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@EnableWebSecurity
public class Securirtyconfig extends WebSecurityConfigurerAdapter{
	
	@Override
protected void configure( AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	auth.inMemoryAuthentication().withUser("admin").password("admin").roles("epa");
	
}
	
	@Bean
public PasswordEncoder setencoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	
	
@Override
protected void configure(HttpSecurity http) throws Exception {
http.authorizeHttpRequests().antMatchers("/").permitAll().antMatchers("/epa").hasRole("epa").antMatchers("/user").hasRole("USER").and().formLogin();
	
}	
	
	

}
