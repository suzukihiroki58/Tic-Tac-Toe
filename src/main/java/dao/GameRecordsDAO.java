package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.GameRecord;

public class GameRecordsDAO extends BaseDAO {

	public void upsertGameRecords(GameRecord record) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnection();

			String upsertQuery = "INSERT INTO game_records (user_id, total_games, wins, losses, draws, win_rate) "
					+ "VALUES (?, ?, ?, ?, ?, ?) "
					+ "ON DUPLICATE KEY UPDATE "
					+ "total_games = total_games + 1, "
					+ "wins = wins + VALUES(wins), "
					+ "losses = losses + VALUES(losses), "
					+ "draws = draws + VALUES(draws), "
					+ "win_rate = (wins / total_games) * 100";

			ps = conn.prepareStatement(upsertQuery);
			ps.setInt(1, record.getUserId());
			ps.setInt(2, record.getTotalGames());
			ps.setInt(3, record.getWins());
			ps.setInt(4, record.getLosses());
			ps.setInt(5, record.getDraws());
			ps.setDouble(6, record.getWinRate());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, ps, null);
		}
	}
}
