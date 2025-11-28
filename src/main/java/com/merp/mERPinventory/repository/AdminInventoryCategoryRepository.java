package com.merp.mERPinventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.merp.mERPinventory.response.CategoryDTO;
import com.merp.mERPinventory.model.AdminInventoryCategory;

public interface AdminInventoryCategoryRepository extends JpaRepository<AdminInventoryCategory, Integer> {

	@Query(value = "SELECT c.category_id AS categoryId, c.category_name AS categoryName " +
            "FROM admin_inventory_category c " +
            "JOIN admin_inventory_tenant_map m ON c.category_id = m.category_id " +
            "WHERE m.tenant_id = :tenantId", nativeQuery = true)
    List<CategoryDTO> findCategoriesByTenant(@Param("tenantId") Integer tenantId);
}
