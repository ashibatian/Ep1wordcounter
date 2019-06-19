package father.function.Remote;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "WORDCOUNTER-LOGIN")
public interface HelloRemote {

    @GetMapping("/login")
    public String hello(@RequestParam("username") String username, @RequestParam("password") String password);


}