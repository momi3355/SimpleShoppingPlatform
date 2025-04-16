package co.yedam.mapper;

import java.util.List;
import co.yedam.common.ProductDTO;

public interface ProductMapper {
    List<ProductDTO> getAllProducts(); //전체 검색
    List<ProductDTO> getProductsByCategory(String productCategory); // 카테고리검색
    List<ProductDTO> searchProductsByName(String productName); //이름 검색
    
}