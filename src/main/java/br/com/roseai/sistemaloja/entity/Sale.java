package br.com.roseai.sistemaloja.entity;

import br.com.roseai.sistemaloja.model.Customer;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@Document
public class Sale implements Serializable {

    @Id
    @Schema(
            name = "id",
            description = "Sale's id.",
            example = "543234",
            required = true
    )
    private String id;

    @Schema(
            name = "customer",
            description = "Customer information.",
            required = true
    )
    private Customer customer;

    @Schema(
            name = "totalPrice",
            description = "Sale's total price.",
            example = "210.53",
            required = true
    )
    private Double totalPrice;

    @ArraySchema(schema = @Schema(
            name = "items",
            description = "Array of items id.",
            required = true
    ))
    private List<String> items;

    @Schema(
            name = "paymentForm",
            description = "Payment form used in the sale.",
            example = "credito",
            required = true
    )
    private String paymentForm;

    @Schema(
            name = "creationDate",
            description = "Creation date of the sale.",
            example = "20/10/2021",
            required = true
    )
    private LocalDateTime creationDate;

}
