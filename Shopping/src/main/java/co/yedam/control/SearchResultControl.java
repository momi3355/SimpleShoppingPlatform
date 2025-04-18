package co.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.common.ProductDTO;
import co.yedam.service.ProductService;
import co.yedam.service.ProductServiceImpl;

public class SearchResultControl implements Control {
    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword"); // 검색어만 받음

        Map<String, Object> param = new HashMap<>();
        param.put("productName", keyword); // 이 키워드로 이름 or 카테고리 둘 다 검색

        ProductService service = new ProductServiceImpl();
        List<ProductDTO> resultList = service.getProducts(param);

        req.setAttribute("resultList", resultList);
        req.getRequestDispatcher("searchResult.tiles").forward(req, resp);
    }
}
