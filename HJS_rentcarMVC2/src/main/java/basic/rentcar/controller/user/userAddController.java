package basic.rentcar.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import basic.rentcar.dao.userDAO;
import basic.rentcar.frontController.Controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class userAddController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone"); 
		
		System.out.println(userid + " , " +pwd + " , " +name + " , " +email + " , " +phone);

		HashMap<String, String> vo = new HashMap<String, String>();
		vo.put("userid", userid);
		vo.put("pwd", pwd);
		vo.put("name", name);
		vo.put("email", email);
		vo.put("phone", phone);
		int cnt = userDAO.getInstance().userInsert(vo);
		System.out.println(cnt + " fdsfd");
		if (cnt > 0) {
			return "/main";
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('회원가입 실패'); history.back();</script>");
			writer.close();
			return "insertUser";
		}
	}
}