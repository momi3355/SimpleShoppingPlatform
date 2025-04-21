package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import co.yedam.common.Control;
import co.yedam.service.LoginService;
import co.yedam.service.LoginServiceImpl;
import co.yedam.vo.LoginVO;

public class FindIdControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        LoginVO vo = new LoginVO();
        vo.setUserName(req.getParameter("userName"));
        vo.setPhone(req.getParameter("phone"));
        vo.setEmail(req.getParameter("email"));

        LoginService service = new LoginServiceImpl();
        LoginVO result = service.findId(vo);

        resp.setContentType("application/json;charset=utf-8");

        JsonObject json = new JsonObject();

        if (result != null) {
            String userId = result.getUserId(); 
            String maskedId = maskId(userId);
            json.addProperty("status", "success");
            json.addProperty("userId", maskedId);
        } else {
            json.addProperty("status", "fail");
            json.addProperty("message", "일치하는 정보가 없습니다.");
        }

        resp.getWriter().print(json.toString());
    }

    private String maskId(String userId) {
        if (userId.length() <= 3) {
            return userId.charAt(0) + "**";
        }
        return userId.substring(0, 3) + "*".repeat(userId.length() - 3);
    }
}
