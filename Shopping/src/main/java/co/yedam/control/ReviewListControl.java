package co.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Control;
import co.yedam.common.DataSource;
import co.yedam.mapper.ReviewMapper;
import co.yedam.vo.ReviewVO;

public class ReviewListControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageParam = req.getParameter("page");
        int page = (pageParam == null) ? 1 : Integer.parseInt(pageParam);
        int size = 10;
        int start = (page - 1) * size;

        SqlSession session = DataSource.getInstance().openSession();
        ReviewMapper mapper = session.getMapper(ReviewMapper.class);

        Map<String, Object> param = new HashMap<>();
        param.put("start", start);
        param.put("size", size);

        List<ReviewVO> reviewList = mapper.selectReviewList(param);
        session.close();

        req.setAttribute("reviews", reviewList);
        req.getRequestDispatcher("views/review_list.jsp").forward(req, resp);
    }
}
