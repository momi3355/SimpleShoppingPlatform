package co.yedam.vo;

import lombok.Data;

@Data
public class OrdersVO {
	private int orderCode;
	private int userCode;
	private String userName;
	private String phone;
	private String address;
	private String orderDate;
}
