package com.udea.parcialarqsoftback.model.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDTO {
    @Schema(description = "The product id is automatically generated unique identifier", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Long id;

    @Schema(description = "The product name", requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(min = 3, max = 100, message = "The product name must be between 3 and 100 characters")
    private String name;

    @Schema(description = "The product price", requiredMode = Schema.RequiredMode.REQUIRED)
    @Min(value = 0, message = "The product price must be greater than 0")
    @Max(value = 1000000, message = "The product price must be less than 1000000")
    private Double price;

    @Schema(description = "The product amount", requiredMode = Schema.RequiredMode.REQUIRED)
    @Min(value = 0, message = "The product amount must be greater than 0")
    @Max(value = 1000000, message = "The product amount must be less than 1000000")
    private Integer amount;
}