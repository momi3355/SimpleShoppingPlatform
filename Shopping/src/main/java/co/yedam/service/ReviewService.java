package co.yedam.service;

import java.util.List;

import co.yedam.vo.ReviewVO;

public interface ReviewService {
	boolean addReview(ReviewVO rvo);
	boolean removeReview(int reviewNo, int userCode);
	ReviewVO getReview(int reviewNo);
	List<ReviewVO> reviewList();
}
