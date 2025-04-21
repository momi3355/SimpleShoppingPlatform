package co.yedam.vo;

import lombok.Data;

@Data
public class OrderInfoVO {
	private int productCode;
    private String imageUrlFir;
    private String productName;
    private int quantity;
    private int totalPrice;
    private String orderDate;
}
