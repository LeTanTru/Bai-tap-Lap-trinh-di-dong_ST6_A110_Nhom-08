package vn.iotstar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.iotstar.dto.response.ProductDTO;
import vn.iotstar.service.IProductService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/get-by-category/{categoryId}")
    public ResponseEntity<?> getAllByCategory(@PathVariable Long categoryId) {
        List<ProductDTO> products = productService.getProductsByCategory(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping(path = "/get-top-selling")
    public ResponseEntity<?> getTopSelling() {
        int limit = 10;
        List<ProductDTO> products = productService.getTopSellingProducts(limit);
        return ResponseEntity.status(HttpStatus.CREATED).body(products);
    }

    @GetMapping(path = "/get-recent-product")
    public ResponseEntity<?> getRecentProduct() {
        int dayLimit = 7;
        List<ProductDTO> products = productService.getRecentProducts(dayLimit);
        return ResponseEntity.status(HttpStatus.CREATED).body(products);
    }
}
