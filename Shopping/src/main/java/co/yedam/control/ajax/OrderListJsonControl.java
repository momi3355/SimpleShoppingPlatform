package co.yedam.control.ajax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.OrderListService;
import co.yedam.service.OrderListServiceImpl;
import co.yedam.vo.OrderInfoVO;

public class OrderListJsonControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		String userCode = req.getSession().getAttribute("userCode")+"";
		if (userCode.equals("null")) {
			resp.getWriter().print("[]"); //null
		}
		//String page = req.getParameter("page"); //나중에 사용.
		
		OrderListService olsv = new OrderListServiceImpl();
		List<OrderInfoVO> list =  olsv.getOrderList(Integer.parseInt(userCode));
		Gson gson = new GsonBuilder().create();
		
		System.out.println(list);
		resp.getWriter().print(gson.toJson(list));
	}
}
