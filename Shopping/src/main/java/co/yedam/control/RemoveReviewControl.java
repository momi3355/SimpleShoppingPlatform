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

        // 기본 응답
        String result = "fail";

        try {
            int reviewNo = Integer.parseInt(reviewNoParam);
            int userCode = Integer.parseInt(userCodeParam);

            ReviewService service = new ReviewServiceImpl();
            boolean success = service.removeReview(reviewNo, userCode);
            result = success ? "success" : "fail";
            if (reviewNoParam == null || userCodeParam == null) {
            	resp.getWriter().write("{\"result\":\"fail\", \"error\":\"Missing parameters\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 결과 응답
        resp.setContentType("application/json;charset=UTF-8");
        String json = "{\"result\":\"" + result + "\"}";
        resp.getWriter().write(json);
    }
}
