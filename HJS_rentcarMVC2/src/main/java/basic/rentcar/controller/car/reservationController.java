package basic.rentcar.controller.car;

import java.io.IOException;
import java.util.ArrayList;

import basic.rentcar.dao.rentcarDAO;
import basic.rentcar.frontController.Controller;
import basic.rentcar.vo.rentcar;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class reservationController implements Controller {
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("num"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int usein = Integer.parseInt(request.getParameter("usein"));
		int usewifi = Integer.parseInt(request.getParameter("usewifi"));
		int usenavi = Integer.parseInt(request.getParameter("usenavi"));
		int useseat = Integer.parseInt(request.getParameter("useseat"));
		int dday = Integer.parseInt(request.getParameter("dday"));
		int price = Integer.parseInt(request.getParameter("price"));
		String rday = request.getParameter("rday");
		HttpSession session = request.getSession();
		session.setAttribute("num", num);//
		session.setAttribute("qty", qty);//
		session.setAttribute("usein", usein);
		session.setAttribute("price", price);//
		session.setAttribute("useseat", useseat);
		session.setAttribute("usewifi", usewifi);
		session.setAttribute("usenavi", usenavi);
		session.setAttribute("dday", dday);//
		session.setAttribute("rday", rday);//
		
		return "rentcarReceipt";
	}
}
