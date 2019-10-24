package com.example.consumernotafiscal;

import com.example.consumernotafiscal.Input.CancelamentoInput;
import com.example.consumernotafiscal.Input.CompraInput;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

@EnableBinding(CompraBinding.class)
public class CompraListener {

    @StreamListener(CompraBinding.NOVA_COMPRA)
    public void nota(Message<CompraInput> message) {
        String key = message.getHeaders().get(KafkaHeaders.RECEIVED_MESSAGE_KEY, String.class);
        CompraInput compraInput = message.getPayload();

        System.out.println("::: GERA NOTA ::: KEY: " + key);
        System.out.println(compraInput);

        Acknowledgment ack = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);

        if (ack != null) {
            System.out.println("::: GERA NOTA ::: Acknowledgment provided");
            ack.acknowledge();
        }
    }

    @StreamListener(CompraBinding.CANCELA_COMPRA)
    public void cancelaNota(Message<CancelamentoInput> message) {
        String key = message.getHeaders().get(KafkaHeaders.RECEIVED_MESSAGE_KEY, String.class);
        CancelamentoInput cancelamentoInput = message.getPayload();

        System.out.println("::: CANCELA NOTA ::: KEY: " + key);
        System.out.println(cancelamentoInput);

        Acknowledgment ack = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);

        if (ack != null) {
            System.out.println("::: CANCELA NOTA ::: Acknowledgment provided");
            ack.acknowledge();
        }
    }
}
