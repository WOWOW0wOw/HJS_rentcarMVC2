package basic.rentcar.controller.car;

import java.io.IOException;

import basic.rentcar.dao.rentcarDAO;
import basic.rentcar.frontController.Controller;
import basic.rentcar.util.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class rentcarInsertController implements Controller {
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String[] values = FileUtil.getPartsValue(request, response);
		rentcarDAO.getInstance().insertRentcar(values[0],
												Integer.parseInt(values[1]),
												Integer.parseInt(values[2]),
												Integer.parseInt(values[3]),
												Integer.parseInt(values[4]),
												values[5],
												values[7],
												values[6]);
		return "main";

	}
}
