package co.yedam.mapper;

import java.util.List;
import java.util.Map;

import co.yedam.vo.ReviewVO;

public interface ReviewMapper {
	int insertReview(ReviewVO rvo); // 리뷰 등록
	int removeReview(int reviewid); // 리뷰 삭제
	ReviewVO selectReview(int reviewid); // 리뷰 보기
	
	List<Map<String, Object>> selectListForDT(int i);
}
