package basic.rentcar.controller.car;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import basic.rentcar.dao.rentcarDAO;
import basic.rentcar.dao.reservationDAO;
import basic.rentcar.dao.userDAO;
import basic.rentcar.frontController.Controller;
import basic.rentcar.vo.reservation;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class reservationCompleteController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("num"));
		if(request.getSession().getAttribute("log") == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인 후 이용가능합니다'); location.href='userLogin.do';</script>");
			writer.close();
			return null;
		}
		int log = Integer.parseInt(request.getParameter("log"));
		String userId = userDAO.getInstance().getOneUserId(log);
		int qty = Integer.parseInt(request.getParameter("qty"));
		int usein = Integer.parseInt(request.getParameter("usein"));
		int usewifi = Integer.parseInt(request.getParameter("usewifi"));
		int usenavi = Integer.parseInt(request.getParameter("usenavi"));
		int useseat = Integer.parseInt(request.getParameter("useseat"));
		int dday = Integer.parseInt(request.getParameter("dday"));
		String rday = request.getParameter("rday");
		System.out.println(num + "," + userId + "," + qty + "," + usein + "," + usewifi + "," + usenavi + "," + useseat
				+ "," + dday);
		reservation vo = new reservation(num, userId, qty, dday, rday, usein, usewifi, usenavi, useseat);
		System.out.println(vo.getDday());

		int rs = reservationDAO.getInstance().reservationInsert(vo);
		System.out.println(rs);
		if (rs > 0) {
			int qtyUpdate = rentcarDAO.getInstance().getRentcarQTY(num) - qty;
			System.out.println(num);
			System.out.println(qtyUpdate + "개");
			HashMap<String, Integer> rc = new HashMap<String, Integer>();
			rc.put("num", num);
			rc.put("qty", qtyUpdate);
			rentcarDAO.getInstance().updateQTY(rc);
			return "/main";
		} else {

			return "rentcarOption";
		}

	}

}