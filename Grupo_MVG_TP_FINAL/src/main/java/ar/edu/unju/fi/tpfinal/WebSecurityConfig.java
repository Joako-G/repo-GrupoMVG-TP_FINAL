package ar.edu.unju.fi.tpfinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.fi.tpfinal.service.imp.LoginAccountServiceImp;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	ManejadorAuth autenticacion;
	
	String[] resources = new String[] {
			"/include/**","/assets/**","/css/**","/img/**","/js/**","/layer/**","/webjars/**","/layout/**"
	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(resources).permitAll()
				.antMatchers("/","/home","/index","/about","/galeria","/equipo","/contacto").permitAll()
				.antMatchers("/oficina-nueva","/nuevo-empleado","/").hasAnyAuthority("President","VP Sales")
				.antMatchers("/producto-nuevo","/productline-nuevo","/cliente-nuevo","/").hasAuthority("Sales Manager (APAC)")
				.antMatchers("/orden-nueva","/detalle-nuevo","/pago-nuevo","/").hasAuthority("Sales Rep")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.successHandler(autenticacion)
				.failureUrl("/login?error=true")
				.usernameParameter("username")
				.passwordParameter("password")
				.and()
			.logout()
				.permitAll()
				.logoutSuccessUrl("/login");
		//http.csrf().disable();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	@Autowired
	LoginAccountServiceImp userDetailsService;
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}
