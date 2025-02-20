package vn.iotstar.service;

import vn.iotstar.dto.request.ProductRequestDTO;
import vn.iotstar.dto.response.ProductResponseDTO;

import java.util.List;

public interface IProductService {

    ProductResponseDTO createProduct(ProductRequestDTO request);

    List<ProductResponseDTO> getProductsByCategory(Long categoryId);

    List<ProductResponseDTO> getTopSellingProducts(int limit);

    List<ProductResponseDTO> getRecentProducts(int dayLimit);
}
