package vn.iotstar.mapper;

import org.mapstruct.Mapper;
import vn.iotstar.dto.request.ProductRequestDTO;
import vn.iotstar.dto.response.ProductResponseDTO;
import vn.iotstar.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductRequestDTO dto);

    ProductResponseDTO toDTO(Product entity);
}
