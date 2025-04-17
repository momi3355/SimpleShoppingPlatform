package co.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;

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
	public boolean removeReview(int reviewNo) {
		return mapper.removeReview(reviewNo) == 1;
	}


	@Override
	public ReviewVO getReview(int reviewNo) {
		// TODO Auto-generated method stub
		return null;
	}


}
