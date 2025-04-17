package co.yedam.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Data
public class ReviewVO {
    private int reviewCode;     // 리뷰번호
    private int userCode;       // 작성자 (숫자형)
    private int productCode;    // 상품 (숫자형)
    private String content;     // 리뷰 본문
    private int rating;         // 별점 (1~5)
    private String writeDate;   // 작성일자
}
