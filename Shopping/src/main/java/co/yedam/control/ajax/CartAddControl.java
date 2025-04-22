package co.yedam.control.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import co.yedam.common.Control;
import co.yedam.service.OrderService;
import co.yedam.service.OrderServiceImpl;
import co.yedam.vo.CartVO;

public class CartAddControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		String userCode = req.getSession().getAttribute("userCode")+"";
		if (userCode.equals("null")) {
			resp.getWriter().print("{\"retCode\": \"404\"}");
			return;
		}
		int ucode = Integer.parseInt(userCode);
		int pcode = Integer.parseInt(req.getParameter("product_code"));
		String option = req.getParameter("option");
		
		CartVO cvo = new CartVO();
		cvo.setUserCode(ucode);
		cvo.setProductCode(pcode);
		cvo.setQuantity(1);
		cvo.setProductOption(option);
		
		OrderService osv = new OrderServiceImpl();
		
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<String, String>();
		if (osv.addCart(cvo)) {
			map.put("retCode", "200");
		} else {
			map.put("retCode", "500");
		}
		
		resp.getWriter().print(gson.toJson(map));
	}
}
