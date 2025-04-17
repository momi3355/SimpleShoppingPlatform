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

public class OrderFromControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getMethod().equalsIgnoreCase("POST")) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			String userCode = req.getParameter("user_code");
			String count = req.getParameter("total_count");
			
			map.put("user_code", Integer.parseInt(userCode));
			
			List<Map<String, Integer>> list = new ArrayList<Map<String,Integer>>();
			for (int i = 0; i < Integer.parseInt(count); i++) {
				Map<String, Integer> productMap = new HashMap<String, Integer>();
				Integer proCode = Integer.parseInt(req.getParameter("pro_code_"+i));
				
				//product_mapper.
				
				String quantity = req.getParameter("quantity_"+i);
				
				productMap.put("pro_code", proCode);
				productMap.put("quantity", Integer.parseInt(quantity));
				
				list.add(productMap);
			}
			map.put("datas", list);

			Gson gson = new  GsonBuilder().create();
			req.setAttribute("datas", gson.toJson(map));
			req.getRequestDispatcher("common/order.tiles").forward(req, resp);
		}
	}
}
