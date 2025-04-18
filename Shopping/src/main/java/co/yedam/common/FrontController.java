package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.control.ajax.AddressJsonControl;
import co.yedam.control.ajax.CartJsonControl;
import co.yedam.control.ajax.ConfigReaderControl;
import co.yedam.control.form.CartFromControl;
import co.yedam.control.form.OrderFromControl;
import co.yedam.control.LoginControl;
import co.yedam.control.LoginFormControl;
import co.yedam.control.LogoutControl;
import co.yedam.control.MainControl;
import co.yedam.control.MypageControl;
import co.yedam.control.PaymentSuccessControl;
import co.yedam.control.ProductDetailControl;

import co.yedam.control.RemoveReviewControl;
import co.yedam.control.SignUpControl;
import co.yedam.control.SignUpFormControl;
import co.yedam.control.AddReviewControl;
import co.yedam.control.FindIdControl;
import co.yedam.control.FindPwControl;
import co.yedam.control.ReviewFormControl;
import co.yedam.control.ReviewListControl;
import co.yedam.control.SearchResultControl;

public class FrontController extends HttpServlet {

	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/configReader.do", new ConfigReaderControl());
		
		// 상품 상세페이지
		map.put("/productdetail.do", new ProductDetailControl());
		// 상품 검색
		map.put("/searchResult.do", new SearchResultControl());
		
		// 로그인 페이지
		map.put("/login.do", new LoginControl());
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/logout.do", new LogoutControl());
		map.put("/findId.do", new FindIdControl());
		map.put("/findPw.do", new FindPwControl());
		map.put("/myPage.do", new MypageControl());
//		map.put("/passwordForm.do", new PasswordFormControl());
//		map.put("/checkPw.do", new CheckPwControl());
//		map.put("/changePw.do", new ChangePwControl());
		
		map.put("/signUp.do", new SignUpControl());
		map.put("/signUpForm.do", new SignUpFormControl());

		/* [결제] */
		map.put("/cartFrom.do", new CartFromControl());
		map.put("/cartJson.do", new CartJsonControl());
		map.put("/orderFrom.do", new OrderFromControl());
		map.put("/paymentSuccess.do", new PaymentSuccessControl());
		
		map.put("/addressJson.do", new AddressJsonControl());
		
		
		map.put("/reviewForm.do", new ReviewFormControl());
		map.put("/addReview.do", new AddReviewControl());
		map.put("/reviewlist.do", new ReviewListControl());
		map.put("/removereview.do", new RemoveReviewControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) //
			throws ServletException, IOException {
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());

		Control sub = map.get(path);
		sub.exec(req, resp);

	}
}
