package co.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.Control;
import co.yedam.common.ProductDTO;
import co.yedam.service.ProductServiceImpl;

public class NewProductAjaxControl implements Control {

    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");

        try {
            int page = 1;
            String pageParam = req.getParameter("page");
            if (pageParam != null && !pageParam.isEmpty()) {
                page = Integer.parseInt(pageParam);
            }

            int pageSize = 10; // 한 페이지당 상품 수
            ProductServiceImpl service = new ProductServiceImpl();
            List<ProductDTO> productList = service.getAllProducts(page, pageSize); // ✅ 수정된 부분

            new ObjectMapper().writeValue(resp.getWriter(), productList);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "잘못된 페이지 번호입니다.");
        } catch (Exception e) {
            e.printStackTrace(); // 콘솔 로그 확인!
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "서버 내부 오류");
        }
    }
}


