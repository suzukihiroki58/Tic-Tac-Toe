package model;

public class GameRecord {
	private int userId;
	private int totalGames;
	private int wins;
	private int losses;
	private int draws;
	private double winRate;
	
	public int getUserId() {
		return userId;
	}
	
	public int getTotalGames() {
		return totalGames;
	}
	
	public int getWins() {
		return wins;
	}
	
	public int getLosses() {
		return losses;
	}
	
	public int getDraws() {
		return draws;
	}
	
	public double getWinRate() {
		return winRate;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setTotalGames(int totalGames) {
		this.totalGames = totalGames;
	}
	
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	public void setDraws(int draws) {
		this.draws = draws;
	}

	public void setWinRate(double winRate) {
		this.winRate = winRate;
	}

}
