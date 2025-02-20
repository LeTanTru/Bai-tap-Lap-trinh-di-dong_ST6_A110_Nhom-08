package vn.iotstar.service.impl;

import org.springframework.stereotype.Service;
import vn.iotstar.dto.request.ProductRequestDTO;
import vn.iotstar.dto.response.ProductResponseDTO;
import vn.iotstar.entity.Category;
import vn.iotstar.entity.Product;
import vn.iotstar.mapper.ProductMapper;
import vn.iotstar.repository.CategoryRepository;
import vn.iotstar.repository.ProductRepository;
import vn.iotstar.service.IProductService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO request) {
        Optional<Category> category = categoryRepository.findById(request.getCategoryId());
        Product product = productMapper.toEntity(request);
        product.setCreateDate(new Date());
        product.setCategory(category.get());
        return productMapper.toDTO(productRepository.save(product));
    }

    @Override
    public List<ProductResponseDTO> getProductsByCategory(Long categoryId) {
        return productRepository.findAllByCategoryId(categoryId).stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDTO> getTopSellingProducts(int limit) {
        return productRepository.findTopSellingProducts(limit).stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDTO> getRecentProducts(int dayLimit) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -dayLimit);
        Date startDate = calendar.getTime();
        return productRepository.findRecentProducts(startDate).stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }
}
