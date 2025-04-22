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

    // 전체 상품 조회 (페이지네이션 포함)
    @Override
    public List<ProductDTO> getAllProducts() {
        return mapper.getAllProducts(null); // 전체 상품 조회
    }

    // 페이지네이션을 적용한 상품 조회
    @Override
    public List<ProductDTO> getAllProducts(Integer page, Integer pageSize) {
        // 페이지나 페이지사이즈가 없으면 전체 조회
        if (page == null || pageSize == null) {
            return mapper.getAllProducts(null);
        }

        // 페이지네이션 적용 (offset 계산)
        int offset = (page - 1) * pageSize;

        // 페이지네이션 파라미터 맵에 담기
        Map<String, Object> params = new HashMap<>();
        params.put("pageSize", pageSize); // 한 페이지에 몇 개씩
        params.put("offset", offset); // 시작 위치 (offset)

        // 매퍼에 전달하여 페이징 처리된 상품 리스트 조회
        return mapper.getAllProducts(params);
    }

    // 판매량 기준으로 정렬된 인기 상품 조회
    @Override
    public List<ProductDTO> getPopularProducts() {
        return mapper.getPopularProducts(); // 판매량 기준으로 정렬된 인기 상품
    }

    // 상품 코드로 상세 조회 (이미지 포함)
    @Override
    public ProductDTO getDetailByCode(int code) {
        // 상품 정보 조회
        ProductDTO product = mapper.getProductByCode(code);

        // 이미지 정보 조회
        List<String> images = mapper.getProductImages(code);
        product.setInfoImageUrls(images); // 이미지 URL 세팅

        return product;
    }

    // 상품 코드로 상품 조회
    @Override
    public ProductDTO getByCode(int code) {
        return mapper.getProductByCode(code);
    }

    // 전체 상품 리스트 조회
    @Override
    public List<ProductDTO> productList() {
        return getAllProducts(); // 전체 상품 조회
    }

    // 카테고리나 이름으로 상품 검색
    @Override
    public List<ProductDTO> getProducts(Map<String, Object> params) {
        return mapper.getProducts(params); // 매퍼에서 제공하는 검색 기능 호출
    }
    // 인기상품 
    @Override
    public List<ProductDTO> selectPopularWithPaging(Map<String, Object> params) {
        return mapper.selectPopularWithPaging(params);
    }
}
