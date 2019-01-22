package com.softvision.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.catalina.User;

import com.mysql.cj.Session;
import com.softvision.BO.UserBO;
import com.softvision.DAO.UserDao;

public class validation implements Filter {
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
		HttpSession session = ((HttpServletRequest) req).getSession(false);
		String userName = httpServletRequest.getParameter("name");
		String password = httpServletRequest.getParameter("pass");
		session = ((HttpServletRequest) req).getSession();


		// System.out.println(httpServletRequest.getParameter("first") +
		// "---------filter")
		int result;
		session = ((HttpServletRequest) req).getSession();
		session.setAttribute("name", userName);
		UserBO userBO = new UserBO();
		try {

			userBO.setUserName(userName);
			userBO.setPassword(password);
			System.out.println("connection object---" + conn);
			result = UserDao.ValidateUser(userBO, conn);

			if (result == 1) {
				System.out.println("login successfull");
				System.out.println("session object" + (String) session.getAttribute("name"));
				httpServletResponse.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
				httpServletResponse.setHeader("Pragma", "no-cache");
				httpServletResponse.setDateHeader("Expires", 0);
				session.setAttribute("name", userName);
				httpServletRequest.getRequestDispatcher("search.jsp").forward(httpServletRequest, httpServletResponse);

			} else if (result == 0) {
				httpServletRequest.setAttribute("msg", "Invalid login! UserName and Password are incorrect.");
				httpServletRequest.getRequestDispatcher("/UserPage.jsp").forward(httpServletRequest,
						httpServletResponse);

			}
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Exception Occured");
		}

	}

}
