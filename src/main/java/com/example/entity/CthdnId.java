package com.example.entity;

import org.hibernate.Hibernate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class CthdnId implements Serializable {
    private static final long serialVersionUID = -672965715860929645L;
    @Column(name = "product_id", nullable = false)
    private Long productId;
    @Column(name = "hoa_don_nhap_id", nullable = false)
    private Long hoaDonNhapId;

    public Long getHoaDonNhapId() {
        return hoaDonNhapId;
    }

    public void setHoaDonNhapId(Long hoaDonNhapId) {
        this.hoaDonNhapId = hoaDonNhapId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, hoaDonNhapId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CthdnId entity = (CthdnId) o;
        return Objects.equals(this.productId, entity.productId) &&
                Objects.equals(this.hoaDonNhapId, entity.hoaDonNhapId);
    }
}