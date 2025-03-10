package basic.rentcar.controller.car;

import java.io.IOException;
import java.io.PrintWriter;
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
		if(request.getSession().getAttribute("log") == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인 후 이용가능합니다'); location.href='userLogin.do';</script>");
			writer.close();
			return null;
		}
		String userId = request.getParameter("loginId");
		System.out.println("userId = " + userId);
		List<reservationViwe> list = reservationDAO.getInstance().reservationList(userId);
		HttpSession session = request.getSession();
		session.setAttribute("list", list);

		return "reservationList";
	}
}
