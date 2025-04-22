package co.yedam.service;

import java.util.List;
import java.util.Map;

import co.yedam.vo.DeliveryVO;

public interface DeliveryService {
    boolean addDelivery(DeliveryVO deliveryVO);
    boolean updateDelivery(DeliveryVO deliveryVO);
    boolean deleteDelivery(int deliveryCode);
    List<DeliveryVO> getByUserCode(int userCode);
    DeliveryVO getByDeliveryCode(int deliveryCode);
    Map<String, Object> getByUserCodeWithUsers(int userCode);
    Map<String, Object> getByDeliveryCodeWithUsers(int deliveryCode);
}
