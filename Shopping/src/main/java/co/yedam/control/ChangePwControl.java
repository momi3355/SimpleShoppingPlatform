package co.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.LoginMapper;

public class ChangePwControl implements Control {

  @Override
  public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String newPw = req.getParameter("newPw");
    String userCodeParam = req.getParameter("userCode");

    SqlSession sqlSession = DataSource.getInstance().openSession(true);
    LoginMapper mapper = sqlSession.getMapper(LoginMapper.class);

    int result = 0;

    if (userCodeParam != null) {
      // 비밀번호 찾기 → 재설정 경로
      int userCode = Integer.parseInt(userCodeParam);
      result = mapper.resetPassword(userCode, newPw);    
    } else {
      // 로그인 상태 → 변경 경로
      HttpSession session = req.getSession();
      Integer userCode = (Integer) session.getAttribute("userCode");
      if (userCode != null) {
    	  result = mapper.resetPassword(userCode, newPw);      
      }
    }

    resp.setContentType("application/json;charset=utf-8");
    PrintWriter out = resp.getWriter();
    if (result > 0) {
      out.print("{\"success\":true}");
    } else {
      out.print("{\"success\":false}");
    }
  }
}
