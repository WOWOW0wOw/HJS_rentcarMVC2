package basic.rentcar.controller.car;

import java.io.IOException;
import java.util.ArrayList;

import basic.rentcar.dao.rentcarDAO;
import basic.rentcar.frontController.Controller;
import basic.rentcar.vo.rentcar;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class rentcarListController implements Controller {
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String category = request.getParameter("cat");
		String com = request.getParameter("com");
		System.out.println(request.getParameter("loginId"));
		ArrayList<rentcar> list = null;
		if (category == null) {
			category = "전체";
		}
		if (com == null) {
			com = "전체";
		}
		if (request.getParameter("loginId") == null || request.getParameter("loginId").equals("admin")) {

			list = (ArrayList<rentcar>) rentcarDAO.getInstance().adminCarlist(category, com);
		} else {
			list = (ArrayList<rentcar>) rentcarDAO.getInstance().getCarlist(category, com);
		}

		request.setAttribute("list", list);
		request.setAttribute("title", com);
		request.setAttribute("category", category);
		request.setAttribute("manufacturer", com);

		return "rentcarList";
	}
}
