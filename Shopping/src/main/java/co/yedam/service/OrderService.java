package co.yedam.service;

import java.util.List;
import java.util.Map;

import co.yedam.vo.OrderItemVO;
import co.yedam.vo.OrdersVO;

public interface OrderService {
	List<Map<String, Object>> getCarts(int userCode);
	int addOrder(OrdersVO ovo);
	int addOrderItem(OrderItemVO oivo);
	int clearCart(int userCode);
	
	Map<String, Object> getOrder(int orderCode);
}
