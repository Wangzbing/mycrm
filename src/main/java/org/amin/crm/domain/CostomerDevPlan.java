package org.amin.crm.domain;

import java.io.Serializable;
import java.util.Date;

public class CostomerDevPlan implements Serializable {
    private Long id;

    private Date plantime;

    private String plansubject;

    private String plandetails;

    private Date inputtime;

    private Long poteId;

    private Long inputuserId;

    private Long plantypeId;

    private Long sellerId;

    private Integer result;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPlantime() {
        return plantime;
    }

    public void setPlantime(Date plantime) {
        this.plantime = plantime;
    }

    public String getPlansubject() {
        return plansubject;
    }

    public void setPlansubject(String plansubject) {
        this.plansubject = plansubject == null ? null : plansubject.trim();
    }

    public String getPlandetails() {
        return plandetails;
    }

    public void setPlandetails(String plandetails) {
        this.plandetails = plandetails == null ? null : plandetails.trim();
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }

    public Long getPoteId() {
        return poteId;
    }

    public void setPoteId(Long poteId) {
        this.poteId = poteId;
    }

    public Long getInputuserId() {
        return inputuserId;
    }

    public void setInputuserId(Long inputuserId) {
        this.inputuserId = inputuserId;
    }

    public Long getPlantypeId() {
        return plantypeId;
    }

    public void setPlantypeId(Long plantypeId) {
        this.plantypeId = plantypeId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
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
        CostomerDevPlan other = (CostomerDevPlan) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPlantime() == null ? other.getPlantime() == null : this.getPlantime().equals(other.getPlantime()))
            && (this.getPlansubject() == null ? other.getPlansubject() == null : this.getPlansubject().equals(other.getPlansubject()))
            && (this.getPlandetails() == null ? other.getPlandetails() == null : this.getPlandetails().equals(other.getPlandetails()))
            && (this.getInputtime() == null ? other.getInputtime() == null : this.getInputtime().equals(other.getInputtime()))
            && (this.getPoteId() == null ? other.getPoteId() == null : this.getPoteId().equals(other.getPoteId()))
            && (this.getInputuserId() == null ? other.getInputuserId() == null : this.getInputuserId().equals(other.getInputuserId()))
            && (this.getPlantypeId() == null ? other.getPlantypeId() == null : this.getPlantypeId().equals(other.getPlantypeId()))
            && (this.getSellerId() == null ? other.getSellerId() == null : this.getSellerId().equals(other.getSellerId()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPlantime() == null) ? 0 : getPlantime().hashCode());
        result = prime * result + ((getPlansubject() == null) ? 0 : getPlansubject().hashCode());
        result = prime * result + ((getPlandetails() == null) ? 0 : getPlandetails().hashCode());
        result = prime * result + ((getInputtime() == null) ? 0 : getInputtime().hashCode());
        result = prime * result + ((getPoteId() == null) ? 0 : getPoteId().hashCode());
        result = prime * result + ((getInputuserId() == null) ? 0 : getInputuserId().hashCode());
        result = prime * result + ((getPlantypeId() == null) ? 0 : getPlantypeId().hashCode());
        result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", plantime=").append(plantime);
        sb.append(", plansubject=").append(plansubject);
        sb.append(", plandetails=").append(plandetails);
        sb.append(", inputtime=").append(inputtime);
        sb.append(", poteId=").append(poteId);
        sb.append(", inputuserId=").append(inputuserId);
        sb.append(", plantypeId=").append(plantypeId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", result=").append(result);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}