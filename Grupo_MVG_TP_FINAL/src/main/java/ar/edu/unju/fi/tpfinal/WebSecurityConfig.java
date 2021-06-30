package ar.edu.unju.fi.tpfinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.fi.tpfinal.service.imp.UsuarioDetailServiceImp;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AutSuccesHandler autSuccesHandler;

	@Autowired
	UsuarioDetailServiceImp usuarioDetailService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioDetailService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/include/**","/css/**","icons/**","/js/**","/layer/**","/layout/**","/webjars/**").permitAll()
				.antMatchers("/","/logout").permitAll()
				.antMatchers("/nuevo-empleado","/guardar-empleado","/empleados","/").hasAnyAuthority("ADMIN")
				.antMatchers("/productos","/productline-listado","/cliente-nuevo","/cliente-guardar","/").hasAnyAuthority("")
				.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/login")
				.successHandler(autSuccesHandler)
				.failureUrl("/login?error=true")
				.permitAll()
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/logout");
	}
	
}
