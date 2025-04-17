package co.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.OrderMapper;

public class OrderServiceImpl implements OrderService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
	
	@Override
	public List<Map<String, Object>> getCarts(int userCode) {
		return mapper.selectCart(userCode);
	}
}
