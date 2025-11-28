package com.merp.mERPinventory.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class InventoryTenantMapId implements Serializable {

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "tenant_id")
    private Integer tenantId;
}
