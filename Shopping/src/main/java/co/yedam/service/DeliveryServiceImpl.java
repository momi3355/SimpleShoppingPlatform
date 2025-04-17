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
    public void addDelivery(DeliveryVO deliveryVO) {
    	mapper.insertDelivery(deliveryVO);
    }

	@Override
    public void updateDelivery(DeliveryVO deliveryVO) {
    	mapper.updateDelivery(deliveryVO);
    }

	@Override
    public void deleteDelivery(int deliveryCode) {
    	mapper.deleteDelivery(deliveryCode);
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
