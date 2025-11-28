package com.merp.mERPinventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.merp.mERPinventory.model.AdminInventoryUom;
import com.merp.mERPinventory.service.AdminInventoryUomService;

@RestController
@RequestMapping("/api/inventory/uom")
@CrossOrigin
public class AdminInventoryUomController {

    @Autowired
    private AdminInventoryUomService service;

    @GetMapping("/all")
    public ResponseEntity<List<AdminInventoryUom>> getAllUoms() {
        return ResponseEntity.ok(service.getAllUoms());
    }
}
