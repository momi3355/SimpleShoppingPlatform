package co.yedam.control.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.DeliveryService;
import co.yedam.service.DeliveryServiceImpl;

public class AddressJsonControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		String deli_code = req.getParameter("dcode");
		
		DeliveryService dsv = new DeliveryServiceImpl();
		Map<String, Object> dvo = dsv.getByDeliveryCodeWithUsers(Integer.parseInt(deli_code));
		
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(dvo));
	}
}
