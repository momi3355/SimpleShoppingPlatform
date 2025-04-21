package co.yedam.service;

import java.util.List;

import co.yedam.vo.OrderInfoVO;

public interface OrderListService {
	List<OrderInfoVO> getOrderList(int orderCode);
}
