package co.yedam.vo;

import lombok.Data;

@Data
public class OrderItemVO {
	private int orderItemCode;
	private int orderCode;
	private int productCode;
	private int quantity;
	private int price;
	private String option;
}
