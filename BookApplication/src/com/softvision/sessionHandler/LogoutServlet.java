package com.softvision.sessionHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String name = (String) session.getAttribute("name");
		String adminName = (String) session.getAttribute("Username");
		System.out.println("session" + name);
		System.out.println("session" + adminName);
		session.removeAttribute("Username");
		session.removeAttribute("name");
		if (session != null) {
			session.invalidate();
		}
		req.getRequestDispatcher("./index.jsp").forward(req, resp);

	}
}
