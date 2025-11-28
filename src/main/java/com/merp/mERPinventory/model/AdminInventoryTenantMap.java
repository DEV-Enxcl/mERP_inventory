package com.merp.mERPinventory.model;

import jakarta.persistence.*;

@Entity
@IdClass(InventoryTenantMapId.class)
@Table(name = "admin_inventory_tenant_map")
public class AdminInventoryTenantMap {

    @Id
    @Column(name = "category_id")
    private Integer categoryId;

    @Id
    @Column(name = "tenant_id")
    private Integer tenantId;

    public AdminInventoryTenantMap() {}

    public AdminInventoryTenantMap(Integer categoryId, Integer tenantId) {
        this.categoryId = categoryId;
        this.tenantId = tenantId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }
}
