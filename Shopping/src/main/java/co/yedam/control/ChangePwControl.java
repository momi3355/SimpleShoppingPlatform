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

public class ChangePwControl implements Control {

    @Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String newPw = req.getParameter("newPassword");

        // 디버깅 로그
        System.out.println("넘어온 새 비밀번호: " + newPw);

        resp.setContentType("application/json;charset=utf-8");
        JsonObject json = new JsonObject();

        // null 또는 빈 문자열 체크
        if (newPw == null || newPw.trim().isEmpty()) {
            json.addProperty("status", "fail");
            json.addProperty("message", "비밀번호가 비어 있습니다.");
            resp.getWriter().print(json.toString());
            return;
        }

        // 로그인된 사용자 userCode 가져오기
        HttpSession session = req.getSession();
        Integer userCode = (Integer) session.getAttribute("userCode");

        if (userCode == null) {
            json.addProperty("status", "fail");
            json.addProperty("message", "로그인 정보가 없습니다.");
            resp.getWriter().print(json.toString());
            return;
        }

        // 비밀번호 변경 처리
        LoginService service = new LoginServiceImpl();
        boolean result = service.changePassword(userCode, newPw);

        if (result) {
            session.invalidate(); // 로그아웃 처리
            json.addProperty("status", "success");
        } else {
            json.addProperty("status", "fail");
            json.addProperty("message", "비밀번호 변경에 실패했습니다.");
        }

        resp.getWriter().print(json.toString());
    }

}
