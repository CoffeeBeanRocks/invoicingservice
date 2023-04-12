package com.example.invoicingservice.model;

public record Payment(int id,
                      String method,
                      String number,
                      Address billingAddress) {
}
