package com.softvision.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.softvision.BO.UserBO;

public class UserDao {
	private static final String VALIDATE_USER_QUERY = "SELECT COUNT(*) FROM bookstore.credentials where name=? and pass=? and type=?";

	public static int ValidateUser(UserBO user, Connection conn) {
		int result = 0;
		try {
			PreparedStatement pst = conn.prepareStatement(VALIDATE_USER_QUERY);

			pst.setString(1, user.getUserName());
			pst.setString(2, user.getPassword());
			pst.setString(3, "user");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				result = rs.getInt(1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
