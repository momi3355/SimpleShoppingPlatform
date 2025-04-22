package co.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import co.yedam.common.ProductDTO;

public interface ProductMapper {
    List<ProductDTO> getAllProducts(Map<String, Object> params);
    ProductDTO getProductByCode(int productCode);
    ProductDTO getProductDetailByCode(int productCode);
    List<ProductDTO> getPopularProducts();
    List<String> getProductImages(int code);
    List<ProductDTO> getProducts(Map<String, Object> params);
    List<ProductDTO> selectPopularWithPaging(Map<String, Object> params);
}
