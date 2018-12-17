package org.amin.crm.domain;

import java.io.Serializable;

public class OrderItem implements Serializable {
    private Long id;

    private Long orderId;

    private Long devicetypeId;

    private Long unittypeId;

    private Integer number;

    private String intro;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getDevicetypeId() {
        return devicetypeId;
    }

    public void setDevicetypeId(Long devicetypeId) {
        this.devicetypeId = devicetypeId;
    }

    public Long getUnittypeId() {
        return unittypeId;
    }

    public void setUnittypeId(Long unittypeId) {
        this.unittypeId = unittypeId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrderItem other = (OrderItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getDevicetypeId() == null ? other.getDevicetypeId() == null : this.getDevicetypeId().equals(other.getDevicetypeId()))
            && (this.getUnittypeId() == null ? other.getUnittypeId() == null : this.getUnittypeId().equals(other.getUnittypeId()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getIntro() == null ? other.getIntro() == null : this.getIntro().equals(other.getIntro()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getDevicetypeId() == null) ? 0 : getDevicetypeId().hashCode());
        result = prime * result + ((getUnittypeId() == null) ? 0 : getUnittypeId().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getIntro() == null) ? 0 : getIntro().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", devicetypeId=").append(devicetypeId);
        sb.append(", unittypeId=").append(unittypeId);
        sb.append(", number=").append(number);
        sb.append(", intro=").append(intro);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}