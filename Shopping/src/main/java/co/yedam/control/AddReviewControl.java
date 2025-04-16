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
		
		// TODO Auto-generated method stub
		
		String rno = req.getParameter("rno");
		String reviewer = req.getParameter("reviewer");
		String review = req.getParameter("review");
		
		ReviewVO rvo = new ReviewVO();
		rvo.setReviewid(Integer.parseInt(rno));
		rvo.setContent(review);
		rvo.setUserid(reviewer);
		System.out.println(rvo);
		
		Gson gson = new GsonBuilder().create();
		Map<String, Object> map = new HashMap<>();
		ReviewService svc = new ReviewServiceImpl();
		if(svc.addReview(rvo)) {
			map.put("retCode", "OK");
			map.put("retVal", rvo);
		} else {
			map.put("retCode", "error");
		}
		String json = gson.toJson(map);
		resp.getWriter().print(json);
	}

}
