package com.softvision.servlet;

import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softvision.BO.BookBO;
import com.softvision.DAO.BookDAO;
import com.softvision.DAO.BookDAOImpl;

@WebServlet("/searchBook")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = -8797086742103508035L;
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		BookDAO bookDAO = null;
		try {
			String searchParam = req.getParameter("searchParam");
			String checkAction = req.getParameter("source");	
			String searchValue = req.getParameter("searchValue");
			bookDAO = new BookDAOImpl();		
			ArrayList<BookBO> bookList = bookDAO.search(searchParam, searchValue);
			req.setAttribute("list", bookList);
			req.setAttribute("searchParam", searchParam);			
			String target;
			if (checkAction.equalsIgnoreCase("Html")) {
				target = "htmlPrint.jsp";
			} else {
				target = "excelScreen.jsp";
			}
			RequestDispatcher rd = req.getRequestDispatcher(target);
			rd.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
