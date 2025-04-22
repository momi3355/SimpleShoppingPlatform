package co.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.LoginService;
import co.yedam.service.LoginServiceImpl;
import co.yedam.vo.BoardVO;

public class NoticeControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService service = new LoginServiceImpl();
        List<BoardVO> list = service.getNotice("notice");
        req.setAttribute("noticeList", list);
        req.getRequestDispatcher("common/notice.tiles").forward(req, resp);
    }
}
