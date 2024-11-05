//package TestRest.testrest.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        String indexURL = "http://localhost:8080/swagger-ui/index.html?urls.primaryName=v2#/";
//        http
//                .csrf().disable()
//        .authorizeRequests().
//        requestMatchers("/**").hasRole("READER")
//                .requestMatchers(HttpMethod.DELETE, "/v1/employees").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.POST, "/v1/employees").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.DELETE, "/v2/employees").hasRole("ADMIN")
//                .requestMatchers(HttpMethod.POST, "/v2/employees").hasRole("ADMIN")
//                .and()
//                .formLogin()
//                .defaultSuccessUrl(indexURL, true);
//        return http.build();
//    }
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails userR = User.withDefaultPasswordEncoder()
//                .username("reader")
//                .password("123")
//                .roles("READER")
//                .build();
//
//        UserDetails userA = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("123")
//                .roles("ADMIN", "READER")
//                .build();
//
//        return new InMemoryUserDetailsManager(userR, userA);
//    }
//}