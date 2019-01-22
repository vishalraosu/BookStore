package com.softvision.filter;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.softvision.BO.AdminBO;
import com.softvision.DAO.AdminDAO;

public class AdminValidationFilter implements Filter {
	Connection conn = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Context envContext;
		try {
			Context initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/mysql");
			conn = ds.getConnection();

		} catch (Exception e) {
			System.out.println("Connection is not created");
			e.printStackTrace();

		}
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) req;
		HttpServletResponse httpServletResponse = (HttpServletResponse) res;
		HttpSession session;
		String userName = httpServletRequest.getParameter("name");
		String password = httpServletRequest.getParameter("pass");
		session = ((HttpServletRequest) req).getSession();
		int result;
		AdminBO adminBO = new AdminBO();
		try {

			adminBO.setAdminname(userName);
			adminBO.setAdminpassword(password);

			result = AdminDAO.ValidateAdmin(adminBO, conn);

			if (result == 1) {

				session.setAttribute("Username", userName);
				httpServletRequest.getRequestDispatcher("UserChoice.jsp").forward(httpServletRequest,
						httpServletResponse);

			} else {

				httpServletRequest.setAttribute("msg1", "Invalid Admin Login and Password ");
				httpServletRequest.getRequestDispatcher("AdminLogin.jsp").forward(httpServletRequest,
						httpServletResponse);

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception Occured");
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
