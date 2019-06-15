package fev.management.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import fev.management.dto.AccountCast;
import fev.management.repository.AccountRepository;

@Configuration
@ComponentScan({"fev.news"})
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(SpringSecurityConfig.class);

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Autowired
    AccountRepository accountRepo;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Cấu hình remember me, thời gian là 1296000 giây
        http.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(1296000);

        http.csrf().disable() // Disable all request
                .authorizeRequests().antMatchers("/soon", "/login", "/vote").permitAll().antMatchers("/management/**")
                .hasAnyRole("Admin")
                // .antMatchers("/user/**", "/index")
                // .hasAnyRole("USER", "ADMIN", "LEADER")
                // .antMatchers("/**").hasAnyRole("ADMIN")
                // .anyRequest().hasAnyRole("ADMIN")
                .anyRequest().authenticated().and().formLogin().defaultSuccessUrl("/index", true).loginPage("/login")
                .permitAll()

                .and().logout().permitAll().and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // //Set Username - Password - Role in memory
//        auth.inMemoryAuthentication()
//                // Admin
//                .withUser("sa").password("123").roles("ADMIN").and().withUser("user").password("123").roles("USER");
        
        List<AccountCast> listAccount = getAll();
        for (int i = 0; i < listAccount.size(); i++) {
            auth.inMemoryAuthentication().withUser(listAccount.get(i).getUsername())
            .password(listAccount.get(i).getPassword())
            .roles(listAccount.get(i).getRole());
        }
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/themes/**");
        // Bỏ chặn các file . . .
    }

    public List<AccountCast> getAll() {

        List<Object[]> list = accountRepo.getAll();
        List<AccountCast> listAccount = new ArrayList<>();
        for (Object[] object : list) {
            int id = (int) object[0];
            String username = (String) object[1];
            String password = (String) object[2];
            String role = (String) object[3];
            String note = (String) object[4];
            listAccount.add(new AccountCast(id, username, password, role, note));
        }

        return (List<AccountCast>) listAccount;
    }

}
