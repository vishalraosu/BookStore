package com.softvision.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.softvision.BO.AdminBO;

public class AdminDAO {
	private static final String VALIDATE_ADMIN_QUERY = "SELECT count(*) FROM bookstore.credentials where name=? and pass=? and type=?";

	public static int ValidateAdmin(AdminBO user, Connection conn) {
		int result = 0;
		try {
			PreparedStatement pst = conn.prepareStatement(VALIDATE_ADMIN_QUERY);
			pst.setString(1, user.getAdminname());
			pst.setString(2, user.getAdminpassword());
			pst.setString(3, "admin");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}

}
