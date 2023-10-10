package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TicTacToeServlet")
public class TicTacToeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/tictactoe.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//フォームでsubmitした数字
		String numberofCell1 = request.getParameter("number");
		//ボタンでsubmitした数字
		String numberofCell2= request.getParameter("action");
		request.setCharacterEncoding("UTF8");
		String message = null;
		if(numberofCell2 != null) {
			message=numberofCell2;
		} else if(numberofCell1 == null || numberofCell1.equals("")) {
			message = "何も入力されていません";
		} else {
			message = numberofCell1;
		}
		request.setAttribute("message", message);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/tictactoe.jsp");
		rd.forward(request, response);
	}

}