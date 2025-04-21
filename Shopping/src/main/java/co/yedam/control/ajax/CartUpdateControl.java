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

public class CartUpdateControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		String ucode = req.getSession().getAttribute("userCode")+"";
		String pcode = req.getParameter("product_code");
		String quantity = req.getParameter("quantity");
		String option = req.getParameter("option");
		
		Gson gson = new Gson();
		
		CartVO cvo = new CartVO();
		cvo.setUserCode(Integer.parseInt(ucode));
		cvo.setProductCode(Integer.parseInt(pcode));
		cvo.setQuantity(Integer.parseInt(quantity));
		cvo.setProductOption(option);
		
		OrderService osv = new OrderServiceImpl();
		
		Map<String, String> map = new HashMap<String, String>();
		if (osv.updateCart(cvo)) {
			map.put("retCode", "200");
		} else {
			map.put("retCode", "500");
		}
		
		resp.getWriter().print(gson.toJson(map));
	}

}
