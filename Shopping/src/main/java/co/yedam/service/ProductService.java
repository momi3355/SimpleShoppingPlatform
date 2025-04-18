package co.yedam.service;

import java.util.List;
import java.util.Map;

import co.yedam.common.ProductDTO;

public interface ProductService {
    List<ProductDTO> productList(); // 전체 상품 조회
    ProductDTO getByCode(int code); //코드로 상품만 조회
	List<ProductDTO> getAllProducts();
	List<ProductDTO> getPopularProducts(); // 판매량으로 정렬조회
	ProductDTO getDetailByCode(int code); // 코드로 이미지 조회
	List<ProductDTO> getProducts(Map<String, Object> params); // 상품 카테고리 이름으로 검색
}