package vn.iotstar.mapper;

import org.mapstruct.Mapper;
import vn.iotstar.dto.response.ProductDTO;
import vn.iotstar.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductDTO dto);

    ProductDTO toDTO(Product entity);
}
