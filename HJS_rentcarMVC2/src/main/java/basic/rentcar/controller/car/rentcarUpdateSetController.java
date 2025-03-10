package basic.rentcar.controller.car;
import java.io.IOException;

import basic.rentcar.dao.rentcarDAO;
import basic.rentcar.frontController.Controller;
import basic.rentcar.util.FileUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@MultipartConfig(
	    maxFileSize = 1024 * 1024 * 1,  // 1MB
	    maxRequestSize = 1024 * 1024 * 10  // 10MB
	)
public class rentcarUpdateSetController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] values = FileUtil.getPartsValue(request, response);
		rentcarDAO.getInstance().updateRentcar(Integer.parseInt(values[9]),
				values[0],
				Integer.parseInt(values[1]),
												Integer.parseInt(values[2]),
												Integer.parseInt(values[3]),
												Integer.parseInt(values[4]),
												values[5],
												values[6],
												values[8]);
		return "main";
	}
}