package co.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import co.yedam.vo.OrderItemVO;
import co.yedam.vo.OrdersVO;

public interface OrderMapper {
	/* [장바구니] */
	//장바구니코드 상품코드, 상품이름, 상품그림, 판매가, 재고수
	List<Map<String, Object>> selectCart(int userCode);
	int insertCart(@Param("userCode")int userCode, @Param("productCode")int productCode);
    int deleteCart(@Param("userCode")int userCode, @Param("productCode")int productCode);
	int allDeleteCart(int userCode);
	
	/* [결제] */
	int insertOrder(OrdersVO ovo);
	int insertOrderItem(OrderItemVO oivo);
	
	Map<String, Object> selectOrder(int orderCode);
}
