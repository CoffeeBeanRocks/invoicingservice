package com.example.invoicingservice.model;

import java.util.Date;
import java.util.List;

public class InvoiceItem {

    private String status;

    private Date on;

    private Address address;

    private List<Item> items;
}
