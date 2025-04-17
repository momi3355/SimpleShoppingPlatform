package co.yedam.control;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Control;
import co.yedam.common.ProductDTO;
import co.yedam.service.ProductService;
import co.yedam.service.ProductServiceImpl;

public class MainControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 서비스 호출
		ProductService service = new ProductServiceImpl();
		List<ProductDTO> allProducts = service.getAllProducts();
		
		 // 최신순 정렬 (신상품)
        List<ProductDTO> newList = allProducts.stream()
             .sorted(Comparator.comparing(ProductDTO::getProductDate).reversed())
             .collect(Collectors.toList());
        
        // 판매량 순 정렬 (인기상품)
        List<ProductDTO> popularList = allProducts.stream()
                .sorted(Comparator.comparingInt(ProductDTO::getSalesCount).reversed())
                .collect(Collectors.toList());

		// 카테고리별 필터링
		List<ProductDTO> outerList = allProducts.stream()
		    .filter(p -> "아우터".equals(p.getProductCategory()))
		    .collect(Collectors.toList());

		List<ProductDTO> topList = allProducts.stream()
		    .filter(p -> "상의".equals(p.getProductCategory()))
		    .collect(Collectors.toList());

		List<ProductDTO> bottomList = allProducts.stream()
		    .filter(p -> "하의".equals(p.getProductCategory()))
		    .collect(Collectors.toList());

		List<ProductDTO> shoesList = allProducts.stream()
		    .filter(p -> "신발".equals(p.getProductCategory()))
		    .collect(Collectors.toList());

		List<ProductDTO> accessoriesList = allProducts.stream()
		    .filter(p -> "패션소품".equals(p.getProductCategory()))
		    .collect(Collectors.toList());

		// JSP로 전달
		req.setAttribute("productList", newList);           // 신상품
	    req.setAttribute("popularList", popularList);       // 인기상품
		req.setAttribute("outerList", outerList);
		req.setAttribute("topList", topList);
		req.setAttribute("bottomList", bottomList);
		req.setAttribute("shoesList", shoesList);
		req.setAttribute("accessoriesList", accessoriesList);

		req.getRequestDispatcher("common/main.tiles").forward(req, resp);
	}
}
