package org.amin.crm.domain;

import java.io.Serializable;
import java.util.Date;

public class PotentialCustomer implements Serializable {
    private Long id;

    private String name;

    private Integer age;

    private Boolean sex;

    private String linkman;

    private String linkmantel;

    private Date inputtime;

    private String intro;

    private String successrate;

    private Integer status;

    private Long customersourceId;

    private Long inputuserId;

    private Long sellerId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLinkmantel() {
        return linkmantel;
    }

    public void setLinkmantel(String linkmantel) {
        this.linkmantel = linkmantel == null ? null : linkmantel.trim();
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getSuccessrate() {
        return successrate;
    }

    public void setSuccessrate(String successrate) {
        this.successrate = successrate == null ? null : successrate.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCustomersourceId() {
        return customersourceId;
    }

    public void setCustomersourceId(Long customersourceId) {
        this.customersourceId = customersourceId;
    }

    public Long getInputuserId() {
        return inputuserId;
    }

    public void setInputuserId(Long inputuserId) {
        this.inputuserId = inputuserId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
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
        PotentialCustomer other = (PotentialCustomer) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getLinkman() == null ? other.getLinkman() == null : this.getLinkman().equals(other.getLinkman()))
            && (this.getLinkmantel() == null ? other.getLinkmantel() == null : this.getLinkmantel().equals(other.getLinkmantel()))
            && (this.getInputtime() == null ? other.getInputtime() == null : this.getInputtime().equals(other.getInputtime()))
            && (this.getIntro() == null ? other.getIntro() == null : this.getIntro().equals(other.getIntro()))
            && (this.getSuccessrate() == null ? other.getSuccessrate() == null : this.getSuccessrate().equals(other.getSuccessrate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCustomersourceId() == null ? other.getCustomersourceId() == null : this.getCustomersourceId().equals(other.getCustomersourceId()))
            && (this.getInputuserId() == null ? other.getInputuserId() == null : this.getInputuserId().equals(other.getInputuserId()))
            && (this.getSellerId() == null ? other.getSellerId() == null : this.getSellerId().equals(other.getSellerId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getLinkman() == null) ? 0 : getLinkman().hashCode());
        result = prime * result + ((getLinkmantel() == null) ? 0 : getLinkmantel().hashCode());
        result = prime * result + ((getInputtime() == null) ? 0 : getInputtime().hashCode());
        result = prime * result + ((getIntro() == null) ? 0 : getIntro().hashCode());
        result = prime * result + ((getSuccessrate() == null) ? 0 : getSuccessrate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCustomersourceId() == null) ? 0 : getCustomersourceId().hashCode());
        result = prime * result + ((getInputuserId() == null) ? 0 : getInputuserId().hashCode());
        result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", sex=").append(sex);
        sb.append(", linkman=").append(linkman);
        sb.append(", linkmantel=").append(linkmantel);
        sb.append(", inputtime=").append(inputtime);
        sb.append(", intro=").append(intro);
        sb.append(", successrate=").append(successrate);
        sb.append(", status=").append(status);
        sb.append(", customersourceId=").append(customersourceId);
        sb.append(", inputuserId=").append(inputuserId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}