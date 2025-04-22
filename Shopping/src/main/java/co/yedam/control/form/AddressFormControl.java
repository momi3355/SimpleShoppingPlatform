package co.yedam.control.form;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.DeliveryService;
import co.yedam.service.DeliveryServiceImpl;
import co.yedam.vo.DeliveryVO;

public class AddressFormControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userCode = req.getSession().getAttribute("userCode")+"";
		if (userCode.equals("null")) {
			resp.sendRedirect("login.do");
			return;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		
		DeliveryService dsv = new DeliveryServiceImpl();
		List<DeliveryVO> deli_list = dsv.getByUserCode(Integer.parseInt(userCode));
		map.put("deli_datas", deli_list);

		Gson gson = new  GsonBuilder().create();
		req.setAttribute("datas", gson.toJson(map));
		req.getRequestDispatcher("common/address.tiles").forward(req, resp);
	}
}
