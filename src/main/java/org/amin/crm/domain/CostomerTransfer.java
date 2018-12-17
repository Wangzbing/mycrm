package org.amin.crm.domain;

import java.io.Serializable;
import java.util.Date;

public class CostomerTransfer implements Serializable {
    private Long id;

    private Long customerId;

    private Long transuserId;

    private Date transtime;

    private Long oldsellerId;

    private Long newsellerId;

    private String transreason;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getTransuserId() {
        return transuserId;
    }

    public void setTransuserId(Long transuserId) {
        this.transuserId = transuserId;
    }

    public Date getTranstime() {
        return transtime;
    }

    public void setTranstime(Date transtime) {
        this.transtime = transtime;
    }

    public Long getOldsellerId() {
        return oldsellerId;
    }

    public void setOldsellerId(Long oldsellerId) {
        this.oldsellerId = oldsellerId;
    }

    public Long getNewsellerId() {
        return newsellerId;
    }

    public void setNewsellerId(Long newsellerId) {
        this.newsellerId = newsellerId;
    }

    public String getTransreason() {
        return transreason;
    }

    public void setTransreason(String transreason) {
        this.transreason = transreason == null ? null : transreason.trim();
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
        CostomerTransfer other = (CostomerTransfer) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getTransuserId() == null ? other.getTransuserId() == null : this.getTransuserId().equals(other.getTransuserId()))
            && (this.getTranstime() == null ? other.getTranstime() == null : this.getTranstime().equals(other.getTranstime()))
            && (this.getOldsellerId() == null ? other.getOldsellerId() == null : this.getOldsellerId().equals(other.getOldsellerId()))
            && (this.getNewsellerId() == null ? other.getNewsellerId() == null : this.getNewsellerId().equals(other.getNewsellerId()))
            && (this.getTransreason() == null ? other.getTransreason() == null : this.getTransreason().equals(other.getTransreason()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getTransuserId() == null) ? 0 : getTransuserId().hashCode());
        result = prime * result + ((getTranstime() == null) ? 0 : getTranstime().hashCode());
        result = prime * result + ((getOldsellerId() == null) ? 0 : getOldsellerId().hashCode());
        result = prime * result + ((getNewsellerId() == null) ? 0 : getNewsellerId().hashCode());
        result = prime * result + ((getTransreason() == null) ? 0 : getTransreason().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", customerId=").append(customerId);
        sb.append(", transuserId=").append(transuserId);
        sb.append(", transtime=").append(transtime);
        sb.append(", oldsellerId=").append(oldsellerId);
        sb.append(", newsellerId=").append(newsellerId);
        sb.append(", transreason=").append(transreason);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}