package co.yedam.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class ReviewVO {
	private int reviewid; // 리뷰번호
	private String userid; // 작성자 ID
	private String productid; // 물품명
	private String content; // 리뷰 본문
	private int rating; // 별점 (1~5)
	private String replyDate; // 댓글작성일자
}
