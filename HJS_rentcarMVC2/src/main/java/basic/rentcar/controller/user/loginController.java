package basic.rentcar.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import basic.rentcar.dao.userDAO;
import basic.rentcar.frontController.Controller;
import basic.rentcar.vo.user;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class loginController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pw = request.getParameter("pwd");
		if (request.getParameter("userid") == null) {
			return "userLogin";
		}

		userDAO dao = userDAO.getInstance();
		user vo = new user();
		vo.setUserId(id);
		vo.setPwd(pw);
		System.out.println(vo.getUserId() + ", " + vo.getPwd());
		String userid = dao.userLogin(vo);
		System.out.println(userid);
		HttpSession session = request.getSession();
		if (userid == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('로그인 실패'); history.back();</script>");
			writer.close();
			return "userLogin";
		} else {
			session.setAttribute("log", dao.getUserNo(id));
			System.out.println(dao.getUserNo(id));
			session.setAttribute("loginId", id);
			if(id.equals("admin")) {
				session.setAttribute("log", -1);
			}
			return "/main";
		}

	}
}