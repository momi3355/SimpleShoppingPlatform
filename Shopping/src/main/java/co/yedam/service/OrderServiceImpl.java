package co.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.OrderMapper;
import co.yedam.vo.OrderItemVO;
import co.yedam.vo.OrdersVO;

public class OrderServiceImpl implements OrderService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
	
	@Override
	public List<Map<String, Object>> getCarts(int userCode) {
		return mapper.selectCart(userCode);
	}

	@Override
	public int addOrder(OrdersVO ovo) {
		return mapper.insertOrder(ovo);
	}

	@Override
	public int addOrderItem(OrderItemVO oivo) {
		return mapper.insertOrderItem(oivo);
	}

	@Override
	public int clearCart(int userCode) {
		return mapper.deleteCart(userCode);
	}

	@Override
	public Map<String, Object> getOrder(int orderCode) {
		return mapper.selectOrder(orderCode);
	}
}
