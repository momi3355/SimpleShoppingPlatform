package co.yedam.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.common.Control;
import co.yedam.service.DeliveryService;
import co.yedam.service.DeliveryServiceImpl;
import co.yedam.service.OrderService;
import co.yedam.service.OrderServiceImpl;
import co.yedam.vo.OrderItemVO;
import co.yedam.vo.OrdersVO;
import lombok.Data;

public class PaymentSuccessControl implements Control {
	@Data
	private class OrderData {
	    private int deli_code;
	    private String product_name;
	    private int payment;
	    private List<ProductData> productData;
	}
	
	@Data
	private class ProductData {
	    private int code;
	    private int quantity;
	    private int price;
	}
	
	public static String convertBufferedReaderToString(BufferedReader reader) throws IOException {
        return reader.lines().collect(Collectors.joining(System.lineSeparator()));
    }
		
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getMethod().equalsIgnoreCase("POST")) {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/json;charset=utf-8");
			String result = convertBufferedReaderToString(req.getReader());
			
			Gson gson = new GsonBuilder().create();
			OrderData orderData = gson.fromJson(result, OrderData.class);
			System.out.println(orderData);
			//json 문자열을 자바 객체로 변환
			
			DeliveryService dsv = new DeliveryServiceImpl();
			Map<String, Object> deliveryMap = dsv.getByDeliveryCodeWithUsers(orderData.getDeli_code());
			
			OrdersVO ovo = new OrdersVO();
			ovo.setUserCode(Integer.parseInt(deliveryMap.get("USER_CODE")+""));
			ovo.setUserName(deliveryMap.get("USER_NAME")+"");
			ovo.setPhone(deliveryMap.get("PHONE")+"");
			ovo.setAddress(deliveryMap.get("POST")+":"+deliveryMap.get("ADDRESS"));
			System.out.println(ovo);
	
			OrderService osv = new OrderServiceImpl();
			int orderCode = osv.addOrder(ovo); //주문테이블 추가
			
			for (ProductData pd : orderData.getProductData()) {
				OrderItemVO oivo = new OrderItemVO();
				oivo.setOrderCode(orderCode);
				//oivo.setOrderCode(0);
				oivo.setProductCode(pd.getCode());
				oivo.setQuantity(pd.getQuantity());
				oivo.setPrice(pd.getPrice());
				System.out.println(oivo);
				
				//osv.addOrderItem(oivo); //주문상세 테이블 추가
			}
			
			//osv.clearCart(Integer.parseInt(deliveryMap.get("USER_CODE")+""));		
			//장바구니 삭제
			Map<String, Object> orderMap = osv.getOrder(orderCode);
			//System.out.println(orderMap);
			
			Map<String, Object> resultDatasMap = new HashMap<String, Object>();
			resultDatasMap.put("order_code", orderMap.get("ORDER_CODE"));
			resultDatasMap.put("order_date", orderMap.get("ORDER_DATE").toString());
			resultDatasMap.put("product_name", orderData.getProduct_name());
			resultDatasMap.put("payment", orderData.getPayment());
			resultDatasMap.put("user_name", orderMap.get("USER_NAME"));
			resultDatasMap.put("user_address", orderMap.get("ADDRESS"));
			resultDatasMap.put("user_phone", orderMap.get("PHONE"));
			
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("recode", "200");
			resultMap.put("datas", resultDatasMap);
			
			resp.getWriter().print(gson.toJson(resultMap));
		} else {
			System.out.println("get");
			req.getRequestDispatcher("common/success.tiles").forward(req, resp);
		}
	}
}
