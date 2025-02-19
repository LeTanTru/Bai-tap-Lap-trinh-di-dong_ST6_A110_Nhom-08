package vn.iotstar.service;

import vn.iotstar.dto.response.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> getProductsByCategory(Long categoryId);

    List<ProductDTO> getTopSellingProducts(int limit);

    List<ProductDTO> getRecentProducts(int dayLimit);
}
