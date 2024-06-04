package com.udea.parcialarqsoftback.model.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StoreDTO {
    @Schema(description = "The store id is automatically generated unique identifier", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Long id;

    @Schema(description = "The store name", requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(min = 3, max = 100, message = "The store name must be between 3 and 100 characters")
    private String name;

    @Schema(description = "The store address",requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(min = 3, max = 100, message = "The store address must be between 3 and 100 characters")
    private String location;

    @Schema(description = "The store phone number",requiredMode = Schema.RequiredMode.REQUIRED)
    @Size(min = 6, max = 10, message = "The store address must be between 6 and 10 characters")
    @Pattern(regexp = "^[0-9]+$", message = "Only number digits are allowed")
    private String phone;
}
