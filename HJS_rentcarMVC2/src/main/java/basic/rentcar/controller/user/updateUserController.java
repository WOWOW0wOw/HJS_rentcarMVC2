package basic.rentcar.controller.user;

import java.io.IOException;

import basic.rentcar.dao.userDAO;
import basic.rentcar.frontController.Controller;
import basic.rentcar.vo.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class updateUserController implements Controller {
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		if (request.getParameter("num") == null) {
			return "memberContent";
		}
		int num = Integer.parseInt(request.getParameter("num"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		user vo = new user();
		vo.setNum(num);
		vo.setEmail(email);
		vo.setPhone(phone);
		String ctx = request.getContextPath();
		int cnt = userDAO.getInstance().userUpdate(vo);
		if (cnt > 0) {
			return "main";

		} else {
			throw new ServletException("not update");
		}
	}
}
