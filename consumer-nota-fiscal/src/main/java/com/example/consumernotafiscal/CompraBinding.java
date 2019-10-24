package com.example.consumernotafiscal;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CompraBinding {

    String NOVA_COMPRA = "input-compra";
    String CANCELA_COMPRA = "input-cancelamento";

    @Input(NOVA_COMPRA)
    SubscribableChannel compras();

    @Input(CANCELA_COMPRA)
    SubscribableChannel cancelamentos();
}
