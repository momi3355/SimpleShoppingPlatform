package co.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import co.yedam.common.Control;
import co.yedam.service.LoginService;
import co.yedam.service.LoginServiceImpl;
import co.yedam.vo.LoginVO;

public class CheckPwControl implements Control {

  @Override
  public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();

    Integer userCode = (Integer) session.getAttribute("userCode");

    resp.setContentType("application/json;charset=utf-8");
    PrintWriter out = resp.getWriter();

    if (userCode == null) {
      out.print("{\"success\":false}");
      return;
    }

    LoginService service = new LoginServiceImpl();
    LoginVO vo = service.getUserInfo(userCode);

    String inputPw = req.getParameter("password");

    if (vo != null && vo.getPassword().equals(inputPw)) {
      out.print("{\"success\":true}");
    } else {
      out.print("{\"success\":false}");
    }
  }
}
