package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import co.yedam.common.Control;
import co.yedam.service.LoginService;
import co.yedam.service.LoginServiceImpl;
import co.yedam.vo.LoginVO;

public class CheckPwControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String inputPw = req.getParameter("password");
		
		HttpSession session = req.getSession();
		Integer userCode = (Integer) session.getAttribute("userCode");
		
		LoginService service = new LoginServiceImpl();
		LoginVO vo = service.getUserInfo(userCode);
		
		resp.setContentType("application/json;charset=utf-8");
	    JsonObject json = new JsonObject();

	    if (vo != null && vo.getPassword().equals(inputPw)) {
	    	json.addProperty("status", "success");
	    } else {
	    	json.addProperty("status", "fail");
	    }

	    resp.getWriter().print(json.toString());
	}

}
