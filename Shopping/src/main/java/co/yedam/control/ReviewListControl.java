package co.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.ReviewService;
import co.yedam.service.ReviewServiceImpl;
import co.yedam.vo.ReviewVO;

public class ReviewListControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReviewService service = new ReviewServiceImpl();
        List<ReviewVO> list = service.reviewList(); // 리스트 조회

        req.setAttribute("reviewList", list); // request에 담기
        req.getRequestDispatcher("/review/reviewList.jsp").forward(req, resp); // JSP로 포워딩
    }
}
