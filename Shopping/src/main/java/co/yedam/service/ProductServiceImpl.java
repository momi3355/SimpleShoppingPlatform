package co.yedam.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.common.ProductDTO;
import co.yedam.mapper.ProductMapper;

public class ProductServiceImpl implements ProductService {
    SqlSession session = DataSource.getInstance().openSession(true);
    ProductMapper mapper = session.getMapper(ProductMapper.class);

    @Override
    public List<ProductDTO> productList() {
        return getAllProducts(); // 할인율 포함된 리스트 반환
    }
    
    @Override
    public List<ProductDTO> getPopularProducts() {
        return mapper.getPopularProducts();
    }
    // 상품코드로 상세이미지 조회
    @Override
    public ProductDTO getDetailByCode(int code) {
      ProductDTO product = mapper.getProductByCode(code);
      List<String> images = mapper.getProductImages(code);
      product.setInfoImageUrls(images);
      return product;
    }
    // 상품코드로 상품 조회
    @Override
    public ProductDTO getByCode(int code) {
    	return mapper.getProductByCode(code);
    }
    
    // 할인율 계산된것
    @Override
    public List<ProductDTO> getAllProducts() {
        return mapper.getAllProducts(); // ✅ 이렇게 수정!
    }
    // 상품 카테고리, 이름 검색
	@Override
	public List<ProductDTO> getProducts(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return mapper.getProducts(params);
	}
}