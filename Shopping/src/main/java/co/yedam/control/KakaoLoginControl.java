package co.yedam.control;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.Control;
import co.yedam.service.LoginService;
import co.yedam.service.LoginServiceImpl;
import co.yedam.vo.LoginVO;

public class KakaoLoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. JSON 요청 파싱
		req.setCharacterEncoding("UTF-8");
	    BufferedReader reader = req.getReader();
	    ObjectMapper mapper = new ObjectMapper();
	    LoginVO kakaoUser = mapper.readValue(reader, LoginVO.class); // kakaoId, email, name 받음

	    LoginService service = new LoginServiceImpl();

	    // 2. 기존 회원 조회
	    LoginVO existingUser = service.getUserByKakaoId(kakaoUser.getKakaoId());

	    // 3. 없으면 회원가입 처리
	    if (existingUser == null) {
	      service.newKakaoUser(kakaoUser);
	      existingUser = service.getUserByKakaoId(kakaoUser.getKakaoId()); // 다시 조회
	    }

	    // 4. 세션에 userCode만 저장
	    req.getSession().setAttribute("userCode", existingUser.getUserCode());

	    // 5. 응답
	    resp.setContentType("application/json;charset=utf-8");
	    resp.getWriter().print("{\"result\": \"success\"}");
	}

}
