package basic.rentcar.controller.car;

import java.io.IOException;

import basic.rentcar.dao.reservationDAO;
import basic.rentcar.frontController.Controller;
import basic.rentcar.vo.reservation;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class reservationUpdateSet implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int regNo = Integer.parseInt(request.getParameter("regNo"));
		String userId = request.getParameter("loginId");
        int num = reservationDAO.getInstance().getRentcarNum(regNo);
        int qty = Integer.parseInt(request.getParameter("qty"));
        int dday = Integer.parseInt(request.getParameter("dday"));
        String rday = request.getParameter("rday");
        int usein = Integer.parseInt(request.getParameter("usein"));
        int usewifi = Integer.parseInt(request.getParameter("usewifi"));
        int usenavi = Integer.parseInt(request.getParameter("usenavi"));
        int useseat = Integer.parseInt(request.getParameter("useseat"));
        System.out.println(regNo+", "+ num+", "+  userId+ ", "+ qty+", "+  dday+ ", "+ rday+", "+  usein+ ", "+ usewifi+ ", "+ usenavi+", "+  useseat);
        reservation vo = new reservation(regNo, num, userId, qty, dday, rday, usein, usewifi, usenavi, useseat);
        
        reservationDAO.getInstance().reservationUpdate(vo);
        String log = request.getParameter("log");
		
		return "main";
	}

}