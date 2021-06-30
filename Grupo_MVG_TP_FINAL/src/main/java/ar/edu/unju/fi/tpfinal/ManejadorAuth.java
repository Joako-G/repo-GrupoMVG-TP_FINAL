package ar.edu.unju.fi.tpfinal;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class ManejadorAuth implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		boolean userVendedor = false;
		boolean userAdmin1 = false;
		boolean userAdmin2 = false;
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		for(GrantedAuthority grantedAuthority : authorities) {
			if(grantedAuthority.getAuthority().equals("Sales Rep")) {
				userVendedor = true;
				break;
			}else {
				if(grantedAuthority.getAuthority().equals("President") || grantedAuthority.getAuthority().equals("VP Sales")) {
					userAdmin1 = true;
					break;
				}else {
					if(grantedAuthority.getAuthority().equals("Sales Manager (APAC)") ) {
						userAdmin2 = true;
						break;
					}
				}
			}
		}
		if(userVendedor) {
			redirectStrategy.sendRedirect(request, response, "/orden-nueva");
		} else {
			if(userAdmin1) {
				redirectStrategy.sendRedirect(request, response, "/nuevo-empleado");
			} else {
				if(userAdmin2) {
					redirectStrategy.sendRedirect(request, response, "/producto-nuevo");
				}else {
					throw new IllegalStateException();
				}
			}
		}
	}

}
