package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.common.ProductDTO;
import co.yedam.service.ProductService;
import co.yedam.service.ProductServiceImpl;

public class ProductInfoControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=UTF-8");
		String productcode = req.getParameter("productCode");
		
		ProductService psv = new ProductServiceImpl();
		ProductDTO pvo = psv.getByCode(Integer.parseInt(productcode));
//		System.out.println(pvo);
		
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(pvo));
	}

}
