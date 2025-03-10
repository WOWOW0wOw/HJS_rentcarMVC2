package basic.rentcar.controller.car;

import java.io.IOException;

import basic.rentcar.dao.reservationDAO;
import basic.rentcar.frontController.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class deleteResrvationController implements Controller {
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int regNo = Integer.parseInt(request.getParameter("regNo"));
		System.out.println("regNo = " + regNo);
		
		reservationDAO.getInstance().reservationDelete(regNo);
		
		return "main";
	}
}
