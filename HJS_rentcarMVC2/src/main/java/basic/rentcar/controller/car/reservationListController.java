package basic.rentcar.controller.car;

import java.io.IOException;
import java.util.List;

import basic.rentcar.dao.reservationDAO;
import basic.rentcar.frontController.Controller;
import basic.rentcar.vo.reservationViwe;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class reservationListController implements Controller {
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("loginId").equals("")) {
			return "main";
		}
		String userId = request.getParameter("loginId");
		System.out.println("userId = " + userId);
		List<reservationViwe> list = reservationDAO.getInstance().reservationList(userId);
		HttpSession session = request.getSession();
		session.setAttribute("list", list);

		return "reservationList";
	}
}
