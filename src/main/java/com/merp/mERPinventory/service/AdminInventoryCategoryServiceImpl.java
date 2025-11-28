package com.merp.mERPinventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merp.mERPinventory.response.CategoryDTO;
import com.merp.mERPinventory.repository.AdminInventoryCategoryRepository;

@Service
public class AdminInventoryCategoryServiceImpl implements AdminInventoryCategoryService {

    @Autowired
    private AdminInventoryCategoryRepository repo;

    @Override
    public List<CategoryDTO> getCategoriesByTenant(Integer tenantId) {
        return repo.findCategoriesByTenant(tenantId);
    }
}
