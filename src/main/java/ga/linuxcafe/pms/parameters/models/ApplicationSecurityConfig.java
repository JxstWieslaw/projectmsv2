//package ga.linuxcafe.pms.parameters.models;
//
//import ga.linuxcafe.pms.parameters.services.MyUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@EnableWebSecurity
//@Configuration
//public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers(
//                        "/",
//                        "/resources/**",
//                        "/assets/**",
//                        "/js/**",
//                        "/css/**",
//                        "/vendor/**",
//                        "/fonts/**",
//                        "/img/**").permitAll()
//                .antMatchers(
//                        "/login",
//                        "/resources/**",
//                        "/js/**",
//                        "/css/**",
//                        "/vendor/**",
//                        "/fonts/**",
//                        "/img/**").permitAll()
//                .antMatchers(
//                        "/register",
//                        "/resources/**",
//                        "/js/**",
//                        "/css/**",
//                        "/vendor/**",
//                        "/fonts/**",
//                        "/img/**").permitAll()
//               .antMatchers("/security/userEdit/**").hasAuthority("ADMIN")
//                .antMatchers(
//                        "/users/addNew").permitAll()
//                .antMatchers(
//                        "/forgotPassword",
//                        "/resources/**",
//                        "/js/**",
//                        "/css/**",
//                        "/vendor/**",
//                        "/fonts/**",
//                        "/img/**").permitAll()
//                .antMatchers(
//                        "/users/resetPassword").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .exceptionHandling().accessDeniedPage("/accessDenied")
//                .and()
//                .formLogin()
//                .defaultSuccessUrl("/index")
//                .loginPage("/login").permitAll()
//                .and()
//                .logout().invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login").permitAll();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    private MyUserDetailsService userDetailsService;
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailsService);
//        provider.setPasswordEncoder(bCryptPasswordEncoder());
//        return provider;
//    }
//
//}
