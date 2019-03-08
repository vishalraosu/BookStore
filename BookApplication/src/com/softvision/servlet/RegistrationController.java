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
	private static final long serialVersionUID = 1L;
	Connection conn = null;

	@Override
	public void init() throws ServletException {
		Context envContext;
		System.out.println("register controller");
		try {
			Context initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/filter");
			conn = ds.getConnection();
			System.out.println(conn);

		} catch (Exception e) {
			System.out.println("Connection is not created");
			e.printStackTrace();

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("name");
		String password = req.getParameter("pass");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String type = "user";
		PrintWriter pw=resp.getWriter();
		RegistrationBO registrationBO = new RegistrationBO();
		int result;
		registrationBO.setUsername(username);
		registrationBO.setPassword(password);
		registrationBO.setPhone(phone);
		registrationBO.setEmail(email);
		registrationBO.setType(type);

		try {

			System.out.println("connection object---" + conn);
			result = RegestrationDAO.registerUser(registrationBO, conn);

			if (result == 1) {
				System.out.println("login successfull");
				req.setAttribute("msg1", "Registered Login for browsing.");
				req.getRequestDispatcher("/UserPage.jsp").forward(req, resp);

			} else if (result == 0) {
				System.out.println(" not successfull");
				pw.print("<font color=white>");
				req.setAttribute("msg1", "Registeration Failed!");
				pw.print("</font>");
				req.getRequestDispatcher("/UserPage.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception Occured");
		}

	}
}
