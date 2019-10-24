package com.example.consumerestoquedistribuicao.Input;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CancelamentoInput {

    private Integer productId;
    private Integer userId;

    @Builder
    public CancelamentoInput(Integer productId, Integer userId) {
        this.productId = productId;
        this.userId = userId;
    }
}
