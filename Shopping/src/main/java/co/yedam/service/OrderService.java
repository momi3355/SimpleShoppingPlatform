package co.yedam.service;

import java.util.List;
import java.util.Map;

import co.yedam.vo.CartVO;
import co.yedam.vo.OrderItemVO;
import co.yedam.vo.OrdersVO;

public interface OrderService {
	List<Map<String, Object>> getCarts(int userCode);
	boolean addCart(CartVO cvo);
	boolean updateCart(CartVO cvo);
	boolean deleteCart(int userCode, int productCode);
	boolean clearCart(int userCode);
	
	int addOrder(OrdersVO ovo);
	boolean addOrderItem(OrderItemVO oivo);
	
	Map<String, Object> getOrder(int orderCode);
	List<Map<String, Object>> getOrderItemByOrderCode(int orderCode);
}
