package co.yedam.mapper;

import java.util.List;
import java.util.Map;

import co.yedam.vo.DeliveryVO;

public interface DeliveryMapper {
    int insertDelivery(DeliveryVO deliveryVO); // 배송 정보 추가
    int updateDelivery(DeliveryVO deliveryVO); // 배송 정보 수정
    int deleteDelivery(int deliveryCode);  // 배송 정보 삭제

    List<DeliveryVO> selectAllDeliveries(); // 전체 배송 정보 검색 (필요에 따라 추가)
    List<DeliveryVO> selectDeliveriesByUserCode(int userCode);
    DeliveryVO selectDeliveryByDeliveryCode(int deliveryCode);
    Map<String, Object> selectDeliveriesByUserCodeWithUsers(int userCode); // 사용자 코드로 배송 정보 검색
    Map<String, Object> selectDeliveryByDeliveryCodeWithUsers(int deliveryCode); // 배송 코드(PK)로 배송 정보 검색

}
