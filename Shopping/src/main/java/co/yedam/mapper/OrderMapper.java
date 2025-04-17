package co.yedam.mapper;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
	/* [장바구니] */
	//장바구니코드 상품코드, 상품이름, 상품그림, 판매가, 재고수
	List<Map<String, Object>> selectCart(int userCode);
	
	/* [결제] */
}
