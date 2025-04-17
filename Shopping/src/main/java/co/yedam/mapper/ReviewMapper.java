package co.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import co.yedam.vo.ReviewVO;

public interface ReviewMapper {
    int insertReview(ReviewVO rvo); // 리뷰 등록
    // 리뷰 삭제: 리뷰코드와 유저코드가 일치할 경우만 삭제
    int removeReview(@Param("reviewCode") int reviewCode, @Param("userCode") int userCode);
    ReviewVO selectReview(int reviewid); // 리뷰 보기
    List<Map<String, Object>> selectListForDT(int i); // (추측) DataTables용 리스트
    List<ReviewVO> selectReviewList(Map<String, Object> param); // 검색/페이징용 리뷰 리스트
}
