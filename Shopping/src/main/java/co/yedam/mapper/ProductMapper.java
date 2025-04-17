package co.yedam.mapper;

import java.util.List;
import co.yedam.common.ProductDTO;

public interface ProductMapper {
    List<ProductDTO> getAllProducts(); //전체 검색
    List<ProductDTO> getProductsByCategory(String productCategory); // 카테고리검색
    ProductDTO getProductByCode(int productCode); // 코드검색
    List<ProductDTO> searchProductsByName(String productName); //이름 검색
    List<ProductDTO> getPopularProducts(); // 판매량순으로 정렬
    ProductDTO getProductByCode(int productCode); // 코드검색
	List<String> getProductImages(int code); // 이미지저장
}