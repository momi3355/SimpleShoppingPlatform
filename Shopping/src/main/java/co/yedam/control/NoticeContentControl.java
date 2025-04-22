package co.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import co.yedam.common.Control;
import co.yedam.service.LoginService;
import co.yedam.service.LoginServiceImpl;
import co.yedam.vo.BoardVO;

public class NoticeContentControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int boardCode = Integer.parseInt(req.getParameter("boardCode"));
        LoginService service = new LoginServiceImpl();
        BoardVO vo = service.getNoticeCode(boardCode);

        resp.setContentType("application/json;charset=utf-8");

        if (vo != null && vo.getBoardContent() != null) {
            Map<String, String> result = new HashMap<>();
            result.put("boardTitle", vo.getBoardTitle());
            result.put("boardDate", vo.getBoardDate());  // DB에서 문자열로 바로 받아옴
            result.put("boardContent", vo.getBoardContent());

            Gson gson = new Gson();
            resp.getWriter().print(gson.toJson(result));
        } else {
            resp.getWriter().print("{\"error\":\"내용이 없습니다.\"}");
        }
    }
}
