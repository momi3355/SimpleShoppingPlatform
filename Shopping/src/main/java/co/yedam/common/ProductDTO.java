package co.yedam.common;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class ProductDTO {
	private int productCode;
	private String productName;
	private int originalPrice;
	private int price;
	private String imageDescription;
	private String imageUrlFir;
	private String imageUrlSe;
	private String imageUrlTh;
	private int stock;
	private String productGender;
	private String productCategory;
	private String productOption;
	private Timestamp productDate;
	private int salesCount; //판매량
	// 할인율 
	private int discountRate;

	public int getDiscountRate() {
	    return discountRate;
	}

	public void setDiscountRate(int discountRate) {
	    this.discountRate = discountRate;
	}
}