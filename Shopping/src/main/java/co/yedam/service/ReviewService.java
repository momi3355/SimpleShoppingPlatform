package co.yedam.service;

import co.yedam.vo.ReviewVO;

public interface ReviewService {
	boolean addReview(ReviewVO rvo);
	boolean removeReview(int reviewNo);
	ReviewVO getReview(int reviewNo);
}
