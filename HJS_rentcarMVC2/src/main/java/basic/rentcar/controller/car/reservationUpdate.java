package basic.rentcar.controller.car;

import java.io.IOException;

import basic.rentcar.dao.reservationDAO;
import basic.rentcar.frontController.Controller;
import basic.rentcar.vo.reservationViwe;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class reservationUpdate implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int regNo = Integer.parseInt(request.getParameter("regNo"));
		reservationViwe vo = reservationDAO.getInstance().getOneReservation(regNo);
		System.out.println(vo.getEndDate());

		request.setAttribute("vo", vo);
		return "reservationUpdate";
	}

}