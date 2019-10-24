package com.example.consumerestoquedistribuicao.Input;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CompraInput {

    private Integer productId;
    private Integer userId;
    private Double price;

    @Builder
    public CompraInput(Integer productId, Integer userId, Double price) {
        this.productId = productId;
        this.userId = userId;
        this.price = price;
    }
}
