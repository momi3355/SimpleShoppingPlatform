package co.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.ReviewService;
import co.yedam.service.ReviewServiceImpl;
import co.yedam.vo.ReviewVO;

public class AddReviewControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String productCode = req.getParameter("productCode");
		String userCode = req.getParameter("userCode");
		String content = req.getParameter("content");
		String rating = req.getParameter("rating");
		
		ReviewVO rvo = new ReviewVO();
		rvo.setProductCode(Integer.parseInt(productCode));
		rvo.setUserCode(Integer.parseInt(userCode));
		rvo.setContent(content);  
		rvo.setRating(Integer.parseInt(rating));
		System.out.println(rvo);
		
		//Gson gson = new GsonBuilder().create();
		//Map<String, Object> map = new HashMap<>();
		ReviewService svc = new ReviewServiceImpl();
		if(svc.addReview(rvo)) {
			// 상품상세
			resp.sendRedirect("productdetail.do?productCode="+productCode);
//			map.put("retCode", "OK");
//			map.put("retVal", rvo);
		} else {
			// 리뷰등록
			req.getRequestDispatcher("common/addreview.tiles").forward(req, resp);
			//map.put("retCode", "error");
		}
//		String json = gson.toJson(map);
//		resp.getWriter().print(json);
	}

}
