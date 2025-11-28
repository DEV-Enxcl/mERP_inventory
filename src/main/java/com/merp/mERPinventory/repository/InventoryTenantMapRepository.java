package com.merp.mERPinventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.merp.mERPinventory.model.AdminInventoryTenantMap;
import com.merp.mERPinventory.model.InventoryTenantMapId;

@Repository
public interface InventoryTenantMapRepository 
        extends JpaRepository<AdminInventoryTenantMap, InventoryTenantMapId> {

    @Query("SELECT m.categoryId FROM AdminInventoryTenantMap m WHERE m.tenantId = :tenantId")
    List<Integer> findCategoryIdsByTenant(@Param("tenantId") Integer tenantId);
}
