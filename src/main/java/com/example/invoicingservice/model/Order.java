package com.example.invoicingservice.model;

import java.util.List;

public record Order(int id,
                    int customerId,
                    float total,
                    Address shippingAddress,
                    List<Item> items,
                    Payment payment) {
}
