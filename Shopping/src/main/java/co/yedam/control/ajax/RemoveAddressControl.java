package co.yedam.control.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.DeliveryService;
import co.yedam.service.DeliveryServiceImpl;

public class RemoveAddressControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		
		String deliCode = req.getParameter("deliCode");
		
		DeliveryService dsv = new DeliveryServiceImpl();
		if (dsv.deleteDelivery(Integer.parseInt(deliCode))) {
			resp.getWriter().println("{ \"retCode\": \"200\"}");
		} else {
			resp.getWriter().println("{ \"retCode\": \"500\"}");
		}
	}
}
