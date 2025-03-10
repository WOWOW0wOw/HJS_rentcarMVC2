package basic.rentcar.controller.user;

import java.io.IOException;
import java.util.ArrayList;

import basic.rentcar.dao.userDAO;
import basic.rentcar.frontController.Controller;
import basic.rentcar.vo.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class userListController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<user> list = userDAO.getInstance().userList();
		request.setAttribute("list", list);
		HttpSession session = request.getSession();
		if (session.getAttribute("log") != null) {
			int num = (int) session.getAttribute("log");
			request.setAttribute("num", num);

		} else {
			request.setAttribute("num", null);
		}
		return "userList";

	}

}