package birenzi.commerce.springboot.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity
public class WebMvcConfig  {
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//	@Autowired
//	private DataSource dataSource;
//
//	@Value("${spring.queries.users-query}")
//	private String usersQuery;
//
//	@Value("${spring.queries.roles-query}")
//	private String rolesQuery;

	

//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().permitAll();
////		.antMatchers("/").permitAll().antMatchers("/login").permitAll()
////				.antMatchers("/registration").permitAll().antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
////				.authenticated().and().csrf().disable().formLogin().loginPage("/login").failureUrl("/login?error=true")
////				.defaultSuccessUrl("/admin/dashboard").usernameParameter("email").passwordParameter("password").and()
////				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/").and()
////				.exceptionHandling().accessDeniedPage("/access-denied");
////	}
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
//				.dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
//	}

}
