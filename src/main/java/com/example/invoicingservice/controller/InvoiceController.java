package com.example.invoicingservice.controller;

import com.example.invoicingservice.model.Invoice;
import com.example.invoicingservice.model.ShippingStatus;
import com.example.invoicingservice.repository.InvoiceRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trackings")
public class InvoiceController {

    private InvoiceRepository repository;

    public InvoiceController(InvoiceRepository repository) {
        this.repository = repository;
    }

    @GetMapping({"/{invoiceId}/{itemId}"})
    public Invoice getInvoiceById(@Valid @PathVariable int invoiceId, @Valid @PathVariable int itemId) {
       return repository.getInvoiceById(invoiceId, itemId);
    }

    @PutMapping({"/{invoiceId}"})
    public void updateInvoiceStatus(@Valid @RequestBody ShippingStatus shippingStatus, @Valid @PathVariable int invoiceId) {
        repository.update(shippingStatus, invoiceId);
    }
}
