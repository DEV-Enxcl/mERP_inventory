package com.merp.mERPinventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.merp.mERPinventory.response.CategoryDTO;
import com.merp.mERPinventory.service.AdminInventoryCategoryService;

@RestController
@RequestMapping("/api/inventory")
@CrossOrigin("*")
public class AdminInventoryCategoryController {

    @Autowired
    private AdminInventoryCategoryService service;

    @GetMapping("/{tenantId}")
    public ResponseEntity<List<CategoryDTO>> getCategoriesByTenant(@PathVariable Integer tenantId) {
        return ResponseEntity.ok(service.getCategoriesByTenant(tenantId));
    }
}
