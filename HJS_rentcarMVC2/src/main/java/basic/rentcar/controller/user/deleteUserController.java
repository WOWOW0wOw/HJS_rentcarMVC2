package basic.rentcar.controller.user;

import java.io.IOException;

import basic.rentcar.dao.userDAO;
import basic.rentcar.frontController.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class deleteUserController implements Controller {
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cnt = userDAO.getInstance().userDelete(request.getParameter("id"));

		if (cnt > 0) {
			return "main";

		} else {
			throw new ServletException("not delete");
		}
	}
}
