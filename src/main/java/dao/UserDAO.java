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
	
	public UserDAO(User ab) {

        try (Connection con = DriverManager.getConnection(url, user, password)) {
        	
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement ps= con.prepareStatement(sql);

            ps.setString(1, ab.getUsername());
            ps.setString(2, ab.getPassword());

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
	
//	public static boolean isUsernameExists(String username){
//		boolean exists = false;
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//
//		try {
//			con = getConnection();
//			String sql = "SELECT USERNAME FROM USERS WHERE USERNAME = ?";
//			ps = con.prepareStatement(sql);
//			ps.setString(1, username);
//			rs = ps.executeQuery();
//			if (rs.next()) {
//				exists = true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			closeResources(con, ps, rs);
//		}
//		return exists;
//	}
}
