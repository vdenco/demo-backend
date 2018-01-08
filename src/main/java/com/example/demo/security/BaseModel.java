package com.example.demo.security;

import com.example.demo.tenant.TenantModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    TenantModel tenant;

    @JsonIgnore
    Long version = 1L;

    @JsonIgnore
    Boolean active = true;

    @JsonIgnore
    @CreationTimestamp
    Date creation;

    @JsonIgnore
    @UpdateTimestamp
    Date modification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TenantModel getTenantModel() {
        return tenant;
    }

    public void setTenantModel(TenantModel tenantModel) {
        this.tenant = tenantModel;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getModification() {
        return modification;
    }

    public void setModification(Date modification) {
        this.modification = modification;
    }
}
