package com.softvision.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.softvision.BO.BookBO;
import com.softvision.DAO.BookDAOImpl;

@WebServlet("/ModifyOperations")
public class BookModifyController extends HttpServlet {

	private static final long serialVersionUID = -8797086742103508035L;

	BookBO bookBO = new BookBO();
	BookDAOImpl bookDAOImpl = new BookDAOImpl();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String choice = req.getParameter("button_type");
		String update = "update";
		String delete = "delete";
		String insert = "insert";
		if (choice.equals("update"))
		{
			try {
				String book_id = req.getParameter("book_id");
				String book_name = req.getParameter("book_name");
				String author_name = req.getParameter("author_name");
				String book_category = req.getParameter("book_category");
				String book_status = req.getParameter("book_status");
			
				bookBO.setBookId(book_id);
				bookBO.setBookName(book_name);
				bookBO.setAuthorName(author_name);
				bookBO.setCategory(book_category);
				bookBO.setStatus(book_status);

				int updateDone = bookDAOImpl.Update(bookBO);
				if (updateDone == 1) {
					req.setAttribute("Msg", "Record has been updated successfully....Thank you!!");
					req.getRequestDispatcher("/update.jsp").forward(req, res);
				} else {
					req.setAttribute("Msg", "Record update is unsuccessful");
					req.getRequestDispatcher("/include.jsp").forward(req, res);
					;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (choice.equals("delete")) {

			String book_id = req.getParameter("book_id");
			int deleteDone = bookDAOImpl.delete(book_id);
			if (deleteDone == 1) {
				req.setAttribute("Msg", "Record has been deleted successfully....Thank you!!");
				req.getRequestDispatcher("/delete.jsp").forward(req, res);
			} else {
				req.setAttribute("Msg", "Record deletion was unsuccessful");
				req.getRequestDispatcher("/delete.jsp").forward(req, res);
				;
			}
		}

		else if (choice.equals("insert")) {

			try {
				bookBO.setBookId(req.getParameter("book_id"));
				bookBO.setBookName(req.getParameter("book_name"));
				bookBO.setAuthorName(req.getParameter("author_name"));
				bookBO.setCategory(req.getParameter("book_category"));
				bookBO.setStatus(req.getParameter("book_status"));

				int insertDone = bookDAOImpl.insert(bookBO);

				if (insertDone == 1) {
					req.setAttribute("Msg", "Record has been inserted successfully....Thank you!!");
					req.getRequestDispatcher("/insert.jsp").forward(req, res);
				} else {
					req.setAttribute("Msg", "Record insert was unsuccessful");
					req.getRequestDispatcher("/insert.jsp").forward(req, res);
					;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
