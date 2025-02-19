package vn.iotstar.service.impl;

import org.springframework.stereotype.Service;
import vn.iotstar.dto.response.ProductDTO;
import vn.iotstar.mapper.ProductMapper;
import vn.iotstar.repository.ProductRepository;
import vn.iotstar.service.IProductService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> getProductsByCategory(Long categoryId) {
        return productRepository.findAllByCategoryId(categoryId).stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getTopSellingProducts(int limit) {
        return productRepository.findTopSellingProducts(limit).stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getRecentProducts(int dayLimit) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -dayLimit);
        Date startDate = calendar.getTime();
        return productRepository.findRecentProducts(startDate).stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }
}
