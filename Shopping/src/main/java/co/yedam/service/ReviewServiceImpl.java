package co.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;

import co.yedam.mapper.ReviewMapper;
import co.yedam.vo.ReviewVO;

public class ReviewServiceImpl implements ReviewService{

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ReviewMapper mapper = sqlSession.getMapper(ReviewMapper.class);
	
	@Override
	public boolean addReview(ReviewVO rvo) {
		return mapper.insertReview(rvo) == 1;
	}

	@Override
	public boolean removeReview(int reviewNo, int userCode) {
	    return mapper.removeReview(reviewNo, userCode) == 1;
	}


	@Override
	public List<ReviewVO> reviewList(int productCode) {
		// TODO Auto-generated method stub
		return mapper.selectReviewsByProduct(productCode);
	}


}
