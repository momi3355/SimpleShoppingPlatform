package co.yedam.vo;

import lombok.Data;

@Data
public class CartVO {
    private int cartCode;
    private int userCode;
    private int productCode;
    private int quantity;
    private String productOption;
}
