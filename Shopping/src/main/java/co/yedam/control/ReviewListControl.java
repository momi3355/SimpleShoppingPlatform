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
        // 1. 파라미터 받기
    	String productcode = req.getParameter("productCode");
    	// 2. 서비스 호출
    	ReviewService service = new ReviewServiceImpl();
        List<ReviewVO> list = service.reviewList(Integer.parseInt(productcode)); // 리스트 조회

        // 3. 결과를 저장
        req.setAttribute("reviewList", list); // request에 담기
        
        // 4. 뷰 페이지로 forward
        req.getRequestDispatcher("/WEB-INF/views/reviewlist.jsp").forward(req, resp); // JSP로 포워딩
    }
}
