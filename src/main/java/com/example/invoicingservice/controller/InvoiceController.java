package com.example.invoicingservice.controller;

import com.example.invoicingservice.model.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final WebClient orderService;

    public InvoiceController(WebClient.Builder webClientBuilder) {
        orderService = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    @GetMapping("/{orderId}")
    public Invoice findByOrderId(@PathVariable int orderId){
        Order order =  orderService.get().uri("/orders/order/{orderId}", orderId).retrieve().bodyToMono(Order.class).block();
        if(order == null)
            throw new IllegalStateException("Order could not be found!");
        Invoice invoice = new Invoice();
        invoice.setTotal(order.total());
        invoice.setPayment(order.payment());
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setItems(order.items());
        invoiceItem.setStatus("Created");
        invoiceItem.setAddress(order.shippingAddress());
        invoiceItem.setOn(null);
        invoice.setInvoiceItems(invoiceItem);
        return invoice;
    }

    @PutMapping("/{orderId}")
    public void updateInvoice(@RequestBody Update update, @PathVariable int orderId){
        Invoice invoice = findByOrderId(orderId);
        invoice.getInvoiceItems().setStatus(update.getStatus());
    }
}
