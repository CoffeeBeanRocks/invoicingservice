package com.example.invoicingservice.repository;

import com.example.invoicingservice.model.Invoice;
import com.example.invoicingservice.model.Item;
import com.example.invoicingservice.model.ShippingStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {
    List<Invoice> invoices = new ArrayList<>();

    public List<Invoice> findAll() {
        return invoices;
    }

    public int create(Invoice invoice) {
        int id = invoices.size() + 1;
        invoice.setCustomerId(id);
        invoices.add(invoice);
        return id;
    }

    public void update(ShippingStatus status, int id) {
        Invoice x = getInvoiceById(id);
        if(x != null) {
            for(Item item : x.getInvoiceItem())
            {
                //TODO: Update Repository
                //TODO: ERROR, no such thing as itemId
            }
        }
        else {
            throw new IllegalStateException("invoice id is not valid");
        }
    }

    public Invoice getInvoiceById(int id) {
        return invoices.stream().filter(x -> x.getCustomerId() == id).findAny().orElse(null);
    }
}
