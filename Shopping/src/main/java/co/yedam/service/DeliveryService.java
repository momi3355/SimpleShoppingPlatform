package co.yedam.service;

import java.util.List;
import java.util.Map;

import co.yedam.vo.DeliveryVO;

public interface DeliveryService {
    void addDelivery(DeliveryVO deliveryVO);
    void updateDelivery(DeliveryVO deliveryVO);
    void deleteDelivery(int deliveryCode);
    List<DeliveryVO> getByUserCode(int userCode);
    DeliveryVO getByDeliveryCode(int deliveryCode);
    Map<String, Object> getByUserCodeWithUsers(int userCode);
    Map<String, Object> getByDeliveryCodeWithUsers(int deliveryCode);
}
