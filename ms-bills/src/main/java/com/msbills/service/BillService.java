package com.msbills.service;

import com.msbills.models.Bill;
import com.msbills.repositories.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillService {
    private final BillRepository repository;

    public List<Bill> getAllBill() {
        return repository.findAll();
    }

    public Bill getBillByID(String id) {
        Optional<Bill> bill = repository.findById(id);

        return bill.get();
    }


    public Bill saveBill(Bill bill) {
        return repository.save(bill);

    }
}