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

        ProductService service = new ProductServiceImpl();
        ProductDTO product = service.getProductByCode(Integer.parseInt(code));

        req.setAttribute("product", product);
        req.getRequestDispatcher("/WEB-INF/views/productDetail.jsp").forward(req, resp);
    }
}