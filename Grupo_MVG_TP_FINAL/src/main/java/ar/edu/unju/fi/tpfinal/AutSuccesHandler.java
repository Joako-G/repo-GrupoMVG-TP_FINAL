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
public class AutSuccesHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		boolean esAdmin = false;
		boolean esConsultor = false;
		
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for(GrantedAuthority granteAuthority : authorities) {
			if(granteAuthority.getAuthority().equals("ADMIN")) {
				esAdmin = true;
				break;
			}else {
				esConsultor = true;
				break;
			}
		}
		if(esAdmin) {
			redirectStrategy.sendRedirect(request, response, "/index");
		}else if(esConsultor) {
			redirectStrategy.sendRedirect(request, response, "/index");
		}else {
			throw new IllegalStateException();
		}
	}

}
