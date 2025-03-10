package basic.rentcar.controller.car;

import java.io.IOException;

import basic.rentcar.frontController.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class rentcarAddAdminController implements Controller {
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		return "rentcarAdd";
	}
}
