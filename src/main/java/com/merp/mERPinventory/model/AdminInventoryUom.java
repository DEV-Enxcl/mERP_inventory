package com.merp.mERPinventory.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admin_inventory_uom")
public class AdminInventoryUom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uom_id")
    private Integer uomId;

    @Column(name = "uom_name", nullable = false, unique = true)
    private String uomName;

    @Column(name = "uom_code", nullable = false, unique = true)
    private String uomCode;

    public AdminInventoryUom() {}

    public AdminInventoryUom(String uomName, String uomCode) {
        this.uomName = uomName;
        this.uomCode = uomCode;
    }

    public Integer getUomId() {
        return uomId;
    }

    public void setUomId(Integer uomId) {
        this.uomId = uomId;
    }

    public String getUomName() {
        return uomName;
    }

    public void setUomName(String uomName) {
        this.uomName = uomName;
    }

    public String getUomCode() {
        return uomCode;
    }

    public void setUomCode(String uomCode) {
        this.uomCode = uomCode;
    }
}
