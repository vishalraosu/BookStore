package com.softvision.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.softvision.BO.BookBO;
import com.softvision.DAO.util.DBConnectionUtil;

public class BookDAOImpl implements BookDAO {

	public String searchQuery = "SELECT BOOK_ID,BOOK_NAME,AUTHOR_NAME,CATEGORY,STATUS FROM BOOKS";
	private static final String UPDATE_BOOK_QUERY = "UPDATE books SET BOOK_NAME =?,AUTHOR_NAME= ?,CATEGORY=?,STATUS=? WHERE BOOK_ID=?";
	private static final String DELETE_BOOK_QUERY = "DELETE FROM books WHERE BOOK_ID=?";
	private static final String INSERT_BOOK_QUERY = "INSERT INTO books VALUES (?,?,?,?,?)";
	Connection con = DBConnectionUtil.getConnection();
	PreparedStatement ps = null;

	@Override
	public ArrayList<BookBO> search(String searchParam, String value) {
		searchQuery = searchQuery + " WHERE " + searchParam + " = ? ";
		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<BookBO> bookList = null;
		//System.out.println("Selection- " + searchParam);
		try {
			ps = con.prepareStatement(searchQuery);
			ps.setString(1, value);
			rs = ps.executeQuery();
			bookList = new ArrayList<BookBO>();
			//System.out.println("executeQuery is Executed " + searchQuery);
			while (rs.next()) {
			//	System.out.println("While is Executing");
				BookBO bookBO = new BookBO();
				bookBO.setBookId(rs.getString(1));
				bookBO.setBookName(rs.getString(2));
				bookBO.setAuthorName(rs.getString(3));
				bookBO.setCategory(rs.getString(4));
				bookBO.setStatus(rs.getString(5));
				bookList.add(bookBO);
				//System.out.println("Inside While");
			}
			//System.out.println("OutSide While");
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return bookList;
	}

	public int Update(BookBO bookBO) {

		int result = 0;
		try {
			ps = con.prepareStatement(UPDATE_BOOK_QUERY);

			ps.setString(1, bookBO.getBookName());
			ps.setString(2, bookBO.getAuthorName());
			ps.setString(3, bookBO.getCategory());
			ps.setString(4, bookBO.getStatus());
			ps.setString(5, bookBO.getBookId());
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public int delete(String book_id) {
		int result = 0;
		try {
			ps = con.prepareStatement(DELETE_BOOK_QUERY);
			ps.setString(1, book_id);
			result = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQl Exception,..!");
			e.printStackTrace();
		}
		return result;

	}

	public int insert(BookBO bookBO) {

		int result = 0;
		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(INSERT_BOOK_QUERY);
			ps.setString(1, bookBO.getBookId());
			ps.setString(2, bookBO.getBookName());
			ps.setString(3, bookBO.getAuthorName());
			ps.setString(4, bookBO.getCategory());
			ps.setString(5, bookBO.getStatus());

			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("exception occured");
		}
		return result;
	}

}
