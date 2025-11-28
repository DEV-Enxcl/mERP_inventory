package com.merp.mERPinventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.merp.mERPinventory.model.AdminInventoryMaster;
import com.merp.mERPinventory.service.AdminInventoryMasterService;

@RestController
@RequestMapping("/api/inventory/master")
@CrossOrigin("*")
public class AdminInventoryMasterController {

    @Autowired
    private AdminInventoryMasterService service;

    @PostMapping("/create")
    public ResponseEntity<AdminInventoryMaster> createInventory(
            @RequestBody AdminInventoryMaster inventory) {

        return ResponseEntity.ok(service.createInventory(inventory));
    }
}
