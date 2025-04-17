package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.ReviewService;
import co.yedam.service.ReviewServiceImpl;

public class RemoveReviewControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reviewNoParam = req.getParameter("reviewNo");
        String userCodeParam = req.getParameter("userCode");

        // 기본 응답값
        String result = "fail";

        try {
            int reviewNo = Integer.parseInt(reviewNoParam);
            int userCode = Integer.parseInt(userCodeParam);

            ReviewService service = new ReviewServiceImpl();
            boolean success = service.removeReview(reviewNo, userCode);

            if (success) {
                result = "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 결과 응답
        resp.setContentType("text/plain;charset=UTF-8");
        resp.getWriter().write(result);
    }
}
