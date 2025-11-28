package com.merp.mERPinventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merp.mERPinventory.model.AdminInventoryUom;
import com.merp.mERPinventory.repository.AdminInventoryUomRepository;

@Service
public class AdminInventoryUomServiceImpl implements AdminInventoryUomService {

    @Autowired
    private AdminInventoryUomRepository repo;

    @Override
    public List<AdminInventoryUom> getAllUoms() {
        return repo.findAll();
    }
}
