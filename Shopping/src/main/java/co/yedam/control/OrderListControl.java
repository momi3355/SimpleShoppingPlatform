package co.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.service.OrderListService;
import co.yedam.service.OrderListServiceImpl;
import co.yedam.vo.OrderInfoVO;

public class OrderListControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userCode = req.getSession().getAttribute("userCode")+"";
		if (userCode.equals("null")) {
			req.getRequestDispatcher("common/main.do").forward(req, resp);
			return;
		}
		req.getRequestDispatcher("common/orderList.tiles").forward(req, resp);
	}
}
