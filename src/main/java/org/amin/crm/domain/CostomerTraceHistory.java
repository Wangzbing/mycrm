package org.amin.crm.domain;

import java.io.Serializable;
import java.util.Date;

public class CostomerTraceHistory implements Serializable {
    private Long id;

    private String title;

    private Date tracetime;

    private Long customerId;

    private Long sellerId;

    private Long tracetypeId;

    private String traceresult;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getTracetime() {
        return tracetime;
    }

    public void setTracetime(Date tracetime) {
        this.tracetime = tracetime;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getTracetypeId() {
        return tracetypeId;
    }

    public void setTracetypeId(Long tracetypeId) {
        this.tracetypeId = tracetypeId;
    }

    public String getTraceresult() {
        return traceresult;
    }

    public void setTraceresult(String traceresult) {
        this.traceresult = traceresult == null ? null : traceresult.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        CostomerTraceHistory other = (CostomerTraceHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTracetime() == null ? other.getTracetime() == null : this.getTracetime().equals(other.getTracetime()))
            && (this.getCustomerId() == null ? other.getCustomerId() == null : this.getCustomerId().equals(other.getCustomerId()))
            && (this.getSellerId() == null ? other.getSellerId() == null : this.getSellerId().equals(other.getSellerId()))
            && (this.getTracetypeId() == null ? other.getTracetypeId() == null : this.getTracetypeId().equals(other.getTracetypeId()))
            && (this.getTraceresult() == null ? other.getTraceresult() == null : this.getTraceresult().equals(other.getTraceresult()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTracetime() == null) ? 0 : getTracetime().hashCode());
        result = prime * result + ((getCustomerId() == null) ? 0 : getCustomerId().hashCode());
        result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
        result = prime * result + ((getTracetypeId() == null) ? 0 : getTracetypeId().hashCode());
        result = prime * result + ((getTraceresult() == null) ? 0 : getTraceresult().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", tracetime=").append(tracetime);
        sb.append(", customerId=").append(customerId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", tracetypeId=").append(tracetypeId);
        sb.append(", traceresult=").append(traceresult);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}