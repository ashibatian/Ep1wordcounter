package wordcounter.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/index").permitAll()//与/ css / **和/ index匹配的请求是完全可访问的
                .antMatchers("/users/{word}").hasRole("USER")//与/ user / **匹配的请求需要用户进行身份验证，并且必须与USER角色关联
                .and()
                .formLogin();//使用自定义登录页面和失败url启用基于表单的身份验证
    }

    /**
     * The name of the configureGlobal method is not important.
     * However, it is important to only configure AuthenticationManagerBuilder
     * in a class annotated with either @EnableWebSecurity,
     * @EnableGlobalMethodSecurity, or @EnableGlobalAuthentication.
     * Doing otherwise has unpredictable results.
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER");
    }
}
