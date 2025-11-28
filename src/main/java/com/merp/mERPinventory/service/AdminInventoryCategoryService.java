package com.merp.mERPinventory.service;

import java.util.List;
import com.merp.mERPinventory.response.CategoryDTO;

public interface AdminInventoryCategoryService {
    List<CategoryDTO> getCategoriesByTenant(Integer tenantId);
}
