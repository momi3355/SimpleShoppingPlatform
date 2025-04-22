package co.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.common.Control;
import co.yedam.service.DeliveryService;
import co.yedam.service.DeliveryServiceImpl;
import co.yedam.vo.DeliveryVO;

public class AddAddressControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getMethod().equalsIgnoreCase("POST")) {
			HttpSession session = req.getSession();
			
			req.setCharacterEncoding("utf-8");
			String name = req.getParameter("name")+"";
			String phone = req.getParameter("phone")+"";
			String zipcode = req.getParameter("zipcode")+"";
			String address = req.getParameter("address")+"";
			String message = req.getParameter("message")+"";
			
			DeliveryVO dvo = new DeliveryVO();
			dvo.setUserCode(Integer.parseInt(session.getAttribute("userCode")+""));
			dvo.setUserName(name);
			dvo.setPhone(phone);
			dvo.setPost(Integer.parseInt(zipcode));
			dvo.setAddress(address);
			dvo.setRequest(message);
			
			
			DeliveryService dsv = new DeliveryServiceImpl();
			dsv.addDelivery(dvo);
			resp.sendRedirect("myPage.do");
		}
	}

}
