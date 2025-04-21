package co.yedam.control.form;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.common.ProductDTO;
import co.yedam.service.DeliveryService;
import co.yedam.service.DeliveryServiceImpl;
import co.yedam.service.ProductService;
import co.yedam.service.ProductServiceImpl;
import co.yedam.vo.DeliveryVO;

public class OrderFormControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getMethod().equalsIgnoreCase("POST")) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			String userCode = req.getParameter("user_code");
			String count = req.getParameter("total_count");
			
			map.put("user_code", Integer.parseInt(userCode));
			
			List<Map<String, String>> pro_list = new ArrayList<Map<String,String>>();
			for (int i = 0; i < Integer.parseInt(count); i++) {
				Map<String, String> productMap = new HashMap<String, String>();
				String proCode = req.getParameter("pro_code_"+i);
				String quantity = req.getParameter("quantity_"+i);
				
				ProductService psv = new ProductServiceImpl();
				ProductDTO pro = psv.getByCode(Integer.parseInt(proCode));
				
				productMap.put("pro_code", proCode);
				productMap.put("pro_name", pro.getProductName());
				productMap.put("pro_img", pro.getImageUrlFir());
				productMap.put("price", pro.getPrice()+"");
				productMap.put("option", pro.getProductOption());
				productMap.put("quantity", quantity);
				
				pro_list.add(productMap);
			}
			map.put("datas", pro_list);
			
			DeliveryService dsv = new DeliveryServiceImpl();
			List<DeliveryVO> deli_list = dsv.getByUserCode(Integer.parseInt(userCode));
			map.put("deli_datas", deli_list);

			Gson gson = new  GsonBuilder().create();
			req.setAttribute("datas", gson.toJson(map));
			req.getRequestDispatcher("common/order.tiles").forward(req, resp);
		} else {
			//get
			Map<String, Object> map = new HashMap<String, Object>();
			
			String userCode = req.getSession().getAttribute("userCode")+"";
			String proCode = req.getParameter("product_code");
			if (userCode.equals("null")) {
				req.getRequestDispatcher("main.do").forward(req, resp);
				return;
			}
			
			map.put("user_code", Integer.parseInt(userCode));
			
			List<Map<String, String>> pro_list = new ArrayList<Map<String,String>>();
			Map<String, String> productMap = new HashMap<String, String>();
			String quantity = "1";
			
			ProductService psv = new ProductServiceImpl();
			ProductDTO pro = psv.getByCode(Integer.parseInt(proCode));
			
			productMap.put("pro_code", proCode);
			productMap.put("pro_name", pro.getProductName());
			productMap.put("pro_img", pro.getImageUrlFir());
			productMap.put("price", pro.getPrice()+"");
			productMap.put("option", pro.getProductOption());
			productMap.put("quantity", quantity);
			
			pro_list.add(productMap);
			map.put("datas", pro_list);
			
			DeliveryService dsv = new DeliveryServiceImpl();
			List<DeliveryVO> deli_list = dsv.getByUserCode(Integer.parseInt(userCode));
			map.put("deli_datas", deli_list);
			
			Gson gson = new  GsonBuilder().create();
			req.setAttribute("datas", gson.toJson(map));
			req.getRequestDispatcher("common/order.tiles").forward(req, resp);
		}
	}
}
