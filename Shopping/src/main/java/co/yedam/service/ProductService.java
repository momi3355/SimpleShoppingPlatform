package co.yedam.service;

import java.util.List;

import co.yedam.common.ProductDTO;

public interface ProductService {
    List<ProductDTO> productList(); // 전체 상품 조회
    List<ProductDTO> getByCategory(String category); // 카테고리 조회
    List<ProductDTO> getByName(String name); // 상품명 조회
	List<ProductDTO> getAllProducts();
}