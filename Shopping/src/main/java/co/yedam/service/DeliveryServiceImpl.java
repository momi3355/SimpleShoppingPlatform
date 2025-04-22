package co.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.mapper.DeliveryMapper;
import co.yedam.vo.DeliveryVO;

public class DeliveryServiceImpl implements DeliveryService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	DeliveryMapper mapper = sqlSession.getMapper(DeliveryMapper.class);

	@Override
    public boolean addDelivery(DeliveryVO deliveryVO) {
    	return mapper.insertDelivery(deliveryVO) > 0;
    }

	@Override
    public boolean updateDelivery(DeliveryVO deliveryVO) {
    	return mapper.updateDelivery(deliveryVO) > 0;
    }

	@Override
    public boolean deleteDelivery(int deliveryCode) {
    	return mapper.deleteDelivery(deliveryCode) > 0;
    }

	@Override
    public List<DeliveryVO> getByUserCode(int userCode) {
        return mapper.selectDeliveriesByUserCode(userCode);
    }

	@Override
    public DeliveryVO getByDeliveryCode(int deliveryCode) {
        return mapper.selectDeliveryByDeliveryCode(deliveryCode);
    }

	@Override
	public Map<String, Object> getByUserCodeWithUsers(int userCode) {
		return mapper.selectDeliveriesByUserCodeWithUsers(userCode);
	}

	@Override
	public Map<String, Object> getByDeliveryCodeWithUsers(int deliveryCode) {
		return mapper.selectDeliveryByDeliveryCodeWithUsers(deliveryCode);
	}
}
