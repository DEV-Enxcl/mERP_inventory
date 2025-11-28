package com.merp.mERPinventory.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merp.mERPinventory.model.AdminInventoryMaster;
import com.merp.mERPinventory.repository.AdminInventoryMasterRepository;

@Service
public class AdminInventoryMasterServiceImpl implements AdminInventoryMasterService {

    @Autowired
    private AdminInventoryMasterRepository repo;

    @Override
    public AdminInventoryMaster createInventory(AdminInventoryMaster inv) {

        // Set created_on
        inv.setCreatedOn(LocalDateTime.now());

        // 🚨 STATUS CALCULATION LOGIC
        int status;

        if (inv.getQuantity().compareTo(new java.math.BigDecimal("0")) == 0) {
            status = 0; // OUT OF STOCK
        } else if (inv.getQuantity().compareTo(inv.getThreshold()) <= 0) {
            status = 1; // LOW STOCK
        } else {
            status = 2; // NORMAL STOCK
        }

        inv.setInventoryStatus(status);

        return repo.save(inv);
    }
}
