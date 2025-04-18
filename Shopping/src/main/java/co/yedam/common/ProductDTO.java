 package co.yedam.common;

import java.sql.Timestamp;
import java.util.List;

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
	private List<String> infoImageUrls; //이미지
	// 할인율 
	public int getDiscountRate() {
	    if (originalPrice > 0 && originalPrice > price) {
	        return (int) Math.round((originalPrice - price) * 100.0 / originalPrice);
	    } else {
	        return 0;
	    }
	}
}