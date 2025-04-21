package co.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import co.yedam.common.Control;
import co.yedam.service.LoginService;
import co.yedam.service.LoginServiceImpl;
import co.yedam.vo.LoginVO;

public class FindPwControl implements Control {

  @Override
  public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // 1) GET 방식 → 비밀번호 재설정 화면 포워딩
    if ("GET".equalsIgnoreCase(req.getMethod())) {
      req.getRequestDispatcher("common/resetPw.tiles").forward(req, resp);
      return;
    }

    // 2) POST 방식 → 사용자 정보 검증
    String userId = req.getParameter("userId");
    String userName = req.getParameter("userName");
    String phone = req.getParameter("phone");
    String email = req.getParameter("email");

    // 3) 서비스 호출
    LoginService service = new LoginServiceImpl();

    // 4) vo 객체로 전달 (MyBatis에서 param 줄이기 위해)
    LoginVO vo = new LoginVO();
    vo.setUserId(userId);
    vo.setUserName(userName);
    vo.setPhone(phone);
    vo.setEmail(email);

    LoginVO result = service.findPw(vo);

    // 5) 결과 반환 (JSON 응답)
    resp.setContentType("application/json;charset=utf-8");
    PrintWriter out = resp.getWriter();

    if (result != null) {
      out.print("{\"success\":true, \"userCode\":" + result.getUserCode() + "}");
    } else {
      out.print("{\"success\":false}");
    }
  }
}
