package basic.rentcar.controller.user;

import java.io.IOException;

import basic.rentcar.dao.userDAO;
import basic.rentcar.frontController.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VaildIdAjaxController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id=request.getParameter("id"); 
		String passData = userDAO.getInstance().isValidId(id)? "notValid" : "valid";
	
		response.getWriter().print(passData); 
		System.out.println(passData);
		
		return null;
	}

}
