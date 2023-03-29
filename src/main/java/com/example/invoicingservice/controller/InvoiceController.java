package com.example.invoicingservice.controller;

import com.example.invoicingservice.model.Invoice;
import com.example.invoicingservice.repository.InvoiceRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private InvoiceRepository repository;

    public InvoiceController(InvoiceRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public int create(@Valid @RequestBody Invoice invoice){
        return repository.create(invoice);
    }

    @GetMapping({"/{id}"})
    public Invoice getInvoiceById(@Valid @PathVariable int id) {
        Invoice invoice = repository.getInvoiceById(id);
        if(invoice == null)
            throw new IllegalStateException("invoice id is not valid");
        else
            return invoice;
    }
}
