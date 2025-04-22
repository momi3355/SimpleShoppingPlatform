package co.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.common.Control;
import co.yedam.common.ProductDTO;
import co.yedam.service.ProductService;
import co.yedam.service.ProductServiceImpl;

public class PopularProductAjaxControl implements Control {

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

            int pageSize = 10;
            int offset = (page - 1) * pageSize;

            Map<String, Object> params = new HashMap<>();
            params.put("limit", pageSize);
            params.put("offset", offset);

            ProductService service = new ProductServiceImpl();
            List<ProductDTO> popularList = service.selectPopularWithPaging(params); // ✅ 수정 완료

            new ObjectMapper().writeValue(resp.getWriter(), popularList);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "잘못된 페이지 번호입니다.");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "서버 내부 오류 발생");
        }
    }
}
