package com.example.wildberriesclone.mapper;

import com.example.wildberriesclone.dto.productProperty.ProductPropertyDto;
import com.example.wildberriesclone.entity.product.ProductProperty;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductPropertyMapper {
    ProductPropertyMapper INSTANCE = Mappers.getMapper(ProductPropertyMapper.class);

    ProductProperty dtoToProductProperty(ProductPropertyDto dto);
    ProductPropertyDto productPropertyToDto(ProductProperty productProperty);
}
