package vn.iotstar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.iotstar.dto.request.ProductRequestDTO;
import vn.iotstar.dto.response.ProductResponseDTO;
import vn.iotstar.dto.response.Response;
import vn.iotstar.service.IProductService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/create-product")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequestDTO request) {
        return new ResponseEntity<Response>(new Response(true, "Thêm Thành công", productService.createProduct(request)), HttpStatus.OK);
    }

    @GetMapping(path = "/get-by-category/{categoryId}")
    public ResponseEntity<?> getAllByCategory(@PathVariable Long categoryId) {
        List<ProductResponseDTO> products = productService.getProductsByCategory(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping(path = "/get-top-selling")
    public ResponseEntity<?> getTopSelling() {
        int limit = 10;
        List<ProductResponseDTO> products = productService.getTopSellingProducts(limit);
        return ResponseEntity.status(HttpStatus.CREATED).body(products);
    }

    @GetMapping(path = "/get-recent-product")
    public ResponseEntity<?> getRecentProduct() {
        int dayLimit = 7;
        List<ProductResponseDTO> products = productService.getRecentProducts(dayLimit);
        return ResponseEntity.status(HttpStatus.CREATED).body(products);
    }
}
