package basic.rentcar.controller.car;

import java.io.IOException;

import basic.rentcar.dao.rentcarDAO;
import basic.rentcar.frontController.Controller;
import basic.rentcar.vo.rentcar;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class rentcarUpdateController implements Controller {
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		System.out.println(num);
		rentcar vo = rentcarDAO.getInstance().oneRentcarInfo(num);

		System.err.println("vo=" + vo);

		request.setAttribute("vo", vo);

		return "updateRentcar";
	}
}
