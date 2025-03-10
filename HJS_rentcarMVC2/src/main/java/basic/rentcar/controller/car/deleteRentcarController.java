package basic.rentcar.controller.car;

import java.io.IOException;

import basic.rentcar.dao.rentcarDAO;
import basic.rentcar.frontController.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class deleteRentcarController implements Controller {
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("regNo"));
		rentcarDAO.getInstance().deleteRentCar(num);
		return "main";
	}
}
