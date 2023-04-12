package com.example.invoicingservice.model;

import java.util.Date;
import java.util.List;

public class Invoice {
    private Date orderPlaced;

    private float total;

    private InvoiceItem invoiceItems;

    private Payment payment;

    public Date getOrderPlaced() {
        return orderPlaced;
    }

    public void setOrderPlaced(Date orderPlaced) {
        this.orderPlaced = orderPlaced;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public InvoiceItem getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(InvoiceItem invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}
