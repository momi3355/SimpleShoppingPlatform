package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.OrderListMapper;
import co.yedam.vo.OrderInfoVO;

public class OrderListServiceImpl implements OrderListService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	OrderListMapper mapper = sqlSession.getMapper(OrderListMapper.class);

	@Override
	public List<OrderInfoVO> getOrderList(int orderCode) {
		return mapper.getOrderItemsByOrderCode(orderCode);
	}
}
