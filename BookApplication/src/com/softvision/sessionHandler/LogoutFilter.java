package com.softvision.sessionHandler;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutFilter")
public class LogoutFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) req;
		HttpServletResponse httpServletResponse = (HttpServletResponse) res;
		HttpSession session = httpServletRequest.getSession();
		String name = (String) session.getAttribute("name");
		String adminName = (String) session.getAttribute("Username");
		System.out.println("session" + name);
		System.out.println("session" + adminName);
		session.removeAttribute("Username");
		session.removeAttribute("name");
		if (session != null) {
			session.invalidate();
		}

		httpServletRequest.getRequestDispatcher("./index.jsp").forward(httpServletRequest, httpServletResponse);

	}
}
