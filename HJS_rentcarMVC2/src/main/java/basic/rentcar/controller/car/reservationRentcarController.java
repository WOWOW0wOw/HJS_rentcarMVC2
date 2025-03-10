package basic.rentcar.controller.car;

import java.io.IOException;

import basic.rentcar.dao.rentcarDAO;
import basic.rentcar.frontController.Controller;
import basic.rentcar.vo.rentcar;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class reservationRentcarController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		HttpSession session = request.getSession();
		session.setAttribute("userId", request.getParameter("userId"));//
		System.out.println("qty= " + qty);
		rentcar car = rentcarDAO.getInstance().oneRentcarInfo(num);
		request.setAttribute("car", car);
		request.setAttribute("qty", qty);
		return "rentcarOption";
	}

}