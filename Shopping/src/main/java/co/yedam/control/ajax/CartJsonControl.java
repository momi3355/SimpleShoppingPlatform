package co.yedam.control.ajax;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.OrderService;
import co.yedam.service.OrderServiceImpl;

public class CartJsonControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		String ucode = req.getParameter("ucode");
		
		OrderService osv = new OrderServiceImpl();
		List<Map<String, Object>> list = osv.getCarts(Integer.parseInt(ucode));
		
		Gson gson = new GsonBuilder().create();
		
		resp.getWriter().print(gson.toJson(list));
	}
}
