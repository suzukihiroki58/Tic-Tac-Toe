package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GameRecordsDAO;
import model.GameRecord;
import model.User;

@WebServlet("/LoginUserRecordServlet")
public class LoginUserRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session != null) {
			User loggedInUser = (User) session.getAttribute("user");
			if (loggedInUser != null) {
				String username = loggedInUser.getUserName();
				request.setAttribute("loggedInUser", username);
			}
		}

		int userId = (Integer) request.getSession().getAttribute("userId");
		GameRecordsDAO dao = new GameRecordsDAO();
		GameRecord record = dao.getLoggedInUserRecord(userId);
		request.setAttribute("gameRecord", record);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/loginUserRecord.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
