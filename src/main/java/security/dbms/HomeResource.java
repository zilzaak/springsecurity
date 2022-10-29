package security.dbms;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
	
	
	@RequestMapping("/user")
	public String user() {
		
		return "<h1>this is for user page</h1>";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		
		return "<h1>this is for admin page</h1>";
	}
	
	@RequestMapping("/")
	public String homepage() {
		
		return "<h1>this is for home page</h1>";
	}

}
