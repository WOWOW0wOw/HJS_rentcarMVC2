package basic.rentcar.controller.user;

import java.io.IOException;

import basic.rentcar.dao.userDAO;
import basic.rentcar.frontController.Controller;
import basic.rentcar.vo.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class userContentController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ctx = request.getContextPath();
		int num = -1;
		if (request.getParameter("num") == null) {
			return "redirect:" + ctx + "/userLogin.do";
		} else {
			num = Integer.parseInt(request.getParameter("num"));
		}
		user vo = userDAO.getInstance().userContent(num);
		request.setAttribute("vo", vo);
		return "userContent"; 
	}

}