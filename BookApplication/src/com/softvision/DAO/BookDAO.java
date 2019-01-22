package com.softvision.DAO;


import java.util.ArrayList;

import com.softvision.BO.BookBO;



public interface BookDAO {
	public ArrayList<BookBO> search(String searchParam, String value);
}