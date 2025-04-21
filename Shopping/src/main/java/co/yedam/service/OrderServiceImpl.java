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
    public boolean addCart(int userCode, int productCode) {
        return mapper.insertCart(userCode, productCode) > 0;
    }
    
	@Override
	public boolean updateCart(int userCode, int productCode, int quantity) {
		return mapper.updateCart(userCode, productCode, quantity) > 0;
	}

    @Override
    public boolean deleteCart(int userCode, int productCode) {
        return mapper.deleteCart(userCode, productCode) > 0;
    }

    @Override
	public int addOrder(OrdersVO ovo) {
		return mapper.insertOrder(ovo);
	}

	@Override
	public boolean addOrderItem(OrderItemVO oivo) {
		return mapper.insertOrderItem(oivo) > 0;
	}

	@Override
	public boolean clearCart(int userCode) {
		return mapper.allDeleteCart(userCode) > 0;
	}

	@Override
	public Map<String, Object> getOrder(int orderCode) {
		return mapper.selectOrder(orderCode);
	}

	@Override
	public List<Map<String, Object>> getOrderItemByOrderCode(int orderCode) {
		return mapper.selectOrderItemsByOrderCode(orderCode);
	}
}
