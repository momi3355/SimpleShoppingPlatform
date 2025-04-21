package co.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.LoginMapper;

public class ResetPasswordControl implements Control {

  @Override
  public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String newPw = req.getParameter("newPassword");
    String userCodeParam = req.getParameter("userCode");

    resp.setContentType("application/json;charset=utf-8");
    PrintWriter out = resp.getWriter();

    if (newPw == null || userCodeParam == null) {
      out.print("{\"success\":false}");
      return;
    }

    int userCode = Integer.parseInt(userCodeParam);
    SqlSession session = DataSource.getInstance().openSession(true);
    LoginMapper mapper = session.getMapper(LoginMapper.class);
    int result = mapper.resetPassword(userCode, newPw);

    out.print(result > 0 ? "{\"success\":true}" : "{\"success\":false}");
  }
}
