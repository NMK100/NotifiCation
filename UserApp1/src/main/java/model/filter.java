package model;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;

@WebFilter("/*")

public class filter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter fichier");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	throws IOException, ServletException{
		
		HttpServletRequest request2 = (HttpServletRequest) request;
		String uri = request2.getRequestURI();
		
		System.out.println("Requete filtre : " + uri);
		
		chain.doFilter(request2, response);
	}
	
	@Override
	public void destroy () {
		System.out.println("Le filter est detruit");
	}
}
