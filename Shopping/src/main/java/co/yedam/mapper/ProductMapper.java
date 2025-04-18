package co.yedam.mapper;

import java.util.List;
import java.util.Map;

import co.yedam.common.ProductDTO;

public interface ProductMapper {
    List<ProductDTO> getAllProducts(); //전체 검색
    ProductDTO getProductByCode(int productCode); // 코드검색
    ProductDTO getProductDetailByCode(int productCode); // 코드로 이미지검색
    List<ProductDTO> getPopularProducts(); // 판매량순으로 정렬
	List<String> getProductImages(int code); // 이미지저장
	List<ProductDTO> getProducts(Map<String, Object> params); // 카테고리,이름검색
}