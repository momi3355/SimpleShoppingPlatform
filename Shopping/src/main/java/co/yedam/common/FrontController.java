package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.control.AddReviewControl;
import co.yedam.control.ChangePwControl;
import co.yedam.control.CheckPwControl;
import co.yedam.control.FindIdControl;
import co.yedam.control.FindPwControl;
import co.yedam.control.KakaoLoginControl;
import co.yedam.control.LeaveAgreeControl;
import co.yedam.control.LeaveControl;
import co.yedam.control.LeaveReasonControl;
import co.yedam.control.LoginControl;
import co.yedam.control.LoginFormControl;
import co.yedam.control.LogoutControl;
import co.yedam.control.MainControl;
import co.yedam.control.MyInfoControl;
import co.yedam.control.MyInfoPwControl;
import co.yedam.control.MypageControl;
import co.yedam.control.NewProductAjaxControl;
import co.yedam.control.OrderListControl;
import co.yedam.control.PasswordFormControl;
import co.yedam.control.PaymentSuccessControl;
import co.yedam.control.PopularProductAjaxControl;
import co.yedam.control.ProductDetailControl;
import co.yedam.control.RemoveReviewControl;
import co.yedam.control.ResetPasswordControl;
import co.yedam.control.ReviewFormControl;
import co.yedam.control.ReviewListControl;
import co.yedam.control.SearchResultControl;
import co.yedam.control.SignUpControl;
import co.yedam.control.SignUpFormControl;
import co.yedam.control.ajax.AddressJsonControl;
import co.yedam.control.ajax.CartAddControl;
import co.yedam.control.ajax.CartJsonControl;
import co.yedam.control.ajax.CartRemoveControl;
import co.yedam.control.ajax.CartUpdateControl;
import co.yedam.control.ajax.ConfigReaderControl;
import co.yedam.control.ajax.OrderListJsonControl;
import co.yedam.control.form.CartFormControl;
import co.yedam.control.form.OrderFormControl;

public class FrontController extends HttpServlet {

    private Map<String, Control> map;

    public FrontController() {
        map = new HashMap<>();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 기본 페이지 맵핑
        map.put("/main.do", new MainControl());
        map.put("/configReader.do", new ConfigReaderControl());

        // AJAX: 신상품 더보기
        map.put("/newproductajax.do", new NewProductAjaxControl());
        map.put("/popularproductajax.do", new PopularProductAjaxControl());

        // 상품 상세페이지
        map.put("/productdetail.do", new ProductDetailControl());
        // 상품 검색
        map.put("/searchResult.do", new SearchResultControl());

        // 로그인 관련 페이지
        map.put("/login.do", new LoginControl());
        map.put("/loginForm.do", new LoginFormControl());
        map.put("/logout.do", new LogoutControl());
        map.put("/findId.do", new FindIdControl());
        map.put("/findPw.do", new FindPwControl());
        map.put("/myPage.do", new MypageControl());
        map.put("/passwordForm.do", new PasswordFormControl());
        map.put("/checkPw.do", new CheckPwControl());
        map.put("/changePw.do", new ChangePwControl());
        map.put("/resetPassword.do", new ResetPasswordControl());
        map.put("/kakaoLogin.do", new KakaoLoginControl());
        map.put("/signUp.do", new SignUpControl());
        map.put("/signUpForm.do", new SignUpFormControl());
        map.put("/myInfoPw.do", new MyInfoPwControl());
        map.put("/myInfo.do", new MyInfoControl());

        // 주문 관련 페이지
        map.put("/orderList.do", new OrderListControl());
        map.put("/orderListJson.do", new OrderListJsonControl());

        /* [결제] */
        map.put("/cartAdd.do", new CartAddControl());
        map.put("/cart.do", new CartFormControl());
        map.put("/cartRemove.do", new CartRemoveControl());
        map.put("/cartUpdate.do", new CartUpdateControl());
        map.put("/cartJson.do", new CartJsonControl());
        map.put("/orderForm.do", new OrderFormControl());
        map.put("/paymentSuccess.do", new PaymentSuccessControl());

        map.put("/addressJson.do", new AddressJsonControl());

        map.put("/reviewForm.do", new ReviewFormControl());
        map.put("/addReview.do", new AddReviewControl());
        map.put("/reviewlist.do", new ReviewListControl());
        map.put("/removereview.do", new RemoveReviewControl());

        // 회원탈퇴 관련 페이지
        map.put("/leaveReason.do", new LeaveReasonControl());
        map.put("/leaveAgree.do", new LeaveAgreeControl());
        map.put("/leave.do", new LeaveControl());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String uri = req.getRequestURI();
        String context = req.getContextPath();
        String path = uri.substring(context.length());

        System.out.println("요청된 경로 path: " + path);

        Control sub = map.get(path);
        if (sub != null) {
            sub.exec(req, resp);  // 해당 요청을 해당 Control로 처리
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);  // 컨트롤러가 없으면 404 응답
        }
    }
}
