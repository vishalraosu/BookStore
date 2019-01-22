package com.softvision.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.softvision.BO.RegistrationBO;
import com.softvision.BO.UserBO;
import com.softvision.DAO.RegestrationDAO;
import com.softvision.DAO.UserDao;

@WebServlet("/register")
public class RegistrationController extends HttpServlet {
	Connection conn = null;

	@Override
	public void init() throws ServletException {
		Context envContext;
		System.out.println("register controller");
		try {
			Context initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/mysql");
			conn = ds.getConnection();
			System.out.println(conn);

		} catch (Exception e) {
			System.out.println("Connection is not created");
			e.printStackTrace();

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = 0;
		try {
			result = RegestrationDAO.registerUser(getInitParam(req), conn);
			if (result == 1) {
				forwardViewName(req, resp, "Registered Login for browsing.");
			} else if (result == 0) {
				forwardViewName(req, resp, "Registeration Failed!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception Occured");
		}

	}

	public void forwardViewName(HttpServletRequest req, HttpServletResponse resp, String msg)
			throws ServletException, IOException {
		req.setAttribute("msg1", msg);
		req.getRequestDispatcher("/UserPage.jsp").forward(req, resp);
	}

	private RegistrationBO getInitParam(HttpServletRequest req) {
		String username = req.getParameter("name");
		String password = req.getParameter("pass");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String type = "user";
		RegistrationBO registrationBO = new RegistrationBO();
		registrationBO.setUsername(username);
		registrationBO.setPassword(password);
		registrationBO.setPhone(phone);
		registrationBO.setEmail(email);
		registrationBO.setType(type);
		return registrationBO;

	}
}
