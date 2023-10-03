package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class UserDAO extends BaseDAO {
	
	private static final String driver = "org.mariadb.jdbc.Driver";
	private static final String url = "jdbc:mariadb://localhost:3306/tictactoe";
	private static final String user = "root";
	private static final String password = "";
	
	public UserDAO(User u) {

        try (Connection con = DriverManager.getConnection(url, user, password)) {
        	
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement ps= con.prepareStatement(sql);

            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());

            int r = ps.executeUpdate();

            if(r != 0) {
                System.out.println("新規登録成功");
            } else {
                System.out.println("新規登録失敗");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
