package co.yedam.mapper;

import java.util.List;

import co.yedam.vo.OrderInfoVO;

public interface OrderListMapper {
	List<OrderInfoVO> getOrderItemsByOrderCode(int orderCode);
}
