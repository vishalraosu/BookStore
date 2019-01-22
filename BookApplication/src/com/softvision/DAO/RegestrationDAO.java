package com.softvision.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.softvision.BO.RegistrationBO;
import com.softvision.BO.UserBO;

public class RegestrationDAO {
	private static final String REGISTER_USER = "INSERT INTO bookstore.credentials VALUES (?,?,?,?,?)";

	public static int registerUser(RegistrationBO registrationBO, Connection conn) {
		int result = 0;
		try {
			PreparedStatement pst = conn.prepareStatement(REGISTER_USER);

			pst.setString(1, registrationBO.getUsername());
			pst.setString(2, registrationBO.getPassword());
			pst.setString(3, registrationBO.getPhone());
			pst.setString(4, registrationBO.getEmail());
			pst.setString(5, registrationBO.getType());

			result = pst.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
