package com.example.wildberriesclone.mapper;

import com.example.wildberriesclone.dto.product.ProductDto;
import com.example.wildberriesclone.dto.product.UpdatedProductDto;
import com.example.wildberriesclone.entity.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product dtoToProduct(ProductDto productDto);

    ProductDto productToDto(Product product);

    Product updatedProductToDto(UpdatedProductDto dto);
}
