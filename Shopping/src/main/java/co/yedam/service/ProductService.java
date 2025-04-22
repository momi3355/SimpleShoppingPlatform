package co.yedam.service;

import java.util.List;
import java.util.Map;

import co.yedam.common.ProductDTO;

public interface ProductService {
    List<ProductDTO> productList(); // 전체 상품 조회
    ProductDTO getByCode(int code);
    List<ProductDTO> getAllProducts(); // 전체
    List<ProductDTO> getAllProducts(Integer page, Integer pageSize); // 페이징
    List<ProductDTO> getPopularProducts();
    ProductDTO getDetailByCode(int code);
    List<ProductDTO> getProducts(Map<String, Object> params);
    List<ProductDTO> selectPopularWithPaging(Map<String, Object> params);// 인기상품 페이징용
}
