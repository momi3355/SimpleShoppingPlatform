package co.yedam.vo;

import lombok.Data;

@Data
public class DeliveryVO {
    private int deliveryCode;
    private int userCode;
    private int post;
    private String address;
    private String request;
}
