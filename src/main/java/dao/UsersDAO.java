package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UsersDAO extends BaseDAO {

	public static void registerUser(User user) {
		try (Connection con = DriverManager.getConnection(url, username, password)) {

			String insertUserQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
			PreparedStatement ps = con.prepareStatement(insertUserQuery);

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());

			int r = ps.executeUpdate();

			if (r != 0) {
				System.out.println("新規登録成功");
			} else {
				System.out.println("新規登録失敗");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static User findUser(User user) {
		User returnUser = new User();

		try (Connection con = DriverManager.getConnection(url, username, password)) {
			String findUserQuery = "SELECT user_id, username, password FROM users WHERE username = ? AND password = ?";
			PreparedStatement ps = con.prepareStatement(findUserQuery);

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				returnUser.setUserId(rs.getInt("user_id"));
				returnUser.setUserName(rs.getString("username"));
				returnUser.setPassword(rs.getString("password"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return returnUser;
	}
}
