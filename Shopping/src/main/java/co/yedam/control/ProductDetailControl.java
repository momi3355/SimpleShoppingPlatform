package co.yedam.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.common.ProductDTO;
import co.yedam.service.ProductService;
import co.yedam.service.ProductServiceImpl;

public class ProductDetailControl implements Control {
    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("product_code");

        if (code != null && code.matches("\\d+")) {
            int productCode = Integer.parseInt(code);

            ProductService service = new ProductServiceImpl();
            ProductDTO product = service.getByCode(productCode);

            req.setAttribute("product", product);

            // ✅ Tiles 사용 시
            req.getRequestDispatcher("/productDetail.tiles").forward(req, resp);
        } else {
            resp.sendRedirect("main.do"); // 잘못된 요청은 메인으로
        }
    }
}