package com.softvision.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softvision.BO.BookBO;
import com.softvision.DAO.BookDAO;
import com.softvision.DAO.BookDAOImpl;

@WebServlet("/Retrive")
public class BookRetriveController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookDAO bookDAO = null;
		try {
			String bookid = req.getParameter("id");
			PrintWriter out=resp.getWriter();
			
			bookDAO = new BookDAOImpl();
			ArrayList<BookBO> book = bookDAO.retrive(bookid);
			
			if (book.size() == 0) 
			{
				req.setAttribute("msg","Book ID not found, please enter valid ID...!");	
			} 
			else {
				BookBO bookBoObje = (BookBO) book.get(0);
				req.setAttribute("bookId", bookBoObje.getBookId());
				req.setAttribute("bookName", bookBoObje.getBookName());
				req.setAttribute("authorName", bookBoObje.getAuthorName());
				req.setAttribute("category", bookBoObje.getCategory());
				req.setAttribute("status", bookBoObje.getStatus());
			}
			RequestDispatcher rd = req.getRequestDispatcher("/include.jsp");
			rd.include(req, resp);
			
			if (req.getAttribute("msg") != null) 
			{
				RequestDispatcher rd1 = req.getRequestDispatcher("/update.jsp");
				rd1.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
