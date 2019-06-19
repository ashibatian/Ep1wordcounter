package father.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class LoginApplication {


    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }
    @GetMapping("/login")
    public String index(@RequestParam("username") String username,@RequestParam("password") String password){
        if(username.equals("user")&&password.equals("123456"))
        return "true";
        else
            return "false";
    }

}
