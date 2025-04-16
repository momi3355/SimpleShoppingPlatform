package co.yedam.service;

import java.util.List;

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
    public List<ProductDTO> getByCategory(String category) {
        return mapper.getProductsByCategory(category);
    }

    @Override
    public List<ProductDTO> getByName(String name) {
        return mapper.searchProductsByName(name);
    }
    
    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> list = mapper.getAllProducts();

        for (ProductDTO dto : list) {
            int original = dto.getOriginalPrice();
            int sale = dto.getPrice();

            if (original > sale) {
                int rate = (original - sale) * 100 / original;
                dto.setDiscountRate(rate);
            } else {
                dto.setDiscountRate(0);
            }

            // 확인 로그
            System.out.println("[" + dto.getProductName() + "] 할인율: " + dto.getDiscountRate() + "%");
        }

        return list;
    }
}