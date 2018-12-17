package org.amin.crm.domain;

import java.io.Serializable;
import java.util.Date;

public class Costomer implements Serializable {
    private Long id;

    private String name;

    private String contacts;

    private Long age;

    private Boolean sex;

    private String tel;

    private String email;

    private String qq;

    private String wechat;

    private Date inputtime;

    private Long inputuserId;

    private Long sellerId;

    private Long jobId;

    private Long salarylevelId;

    private Long customersourceId;

    private Long customerstatusId;

    private Integer status;

    private Integer pool;

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

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
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

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getSalarylevelId() {
        return salarylevelId;
    }

    public void setSalarylevelId(Long salarylevelId) {
        this.salarylevelId = salarylevelId;
    }

    public Long getCustomersourceId() {
        return customersourceId;
    }

    public void setCustomersourceId(Long customersourceId) {
        this.customersourceId = customersourceId;
    }

    public Long getCustomerstatusId() {
        return customerstatusId;
    }

    public void setCustomerstatusId(Long customerstatusId) {
        this.customerstatusId = customerstatusId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPool() {
        return pool;
    }

    public void setPool(Integer pool) {
        this.pool = pool;
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
        Costomer other = (Costomer) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getContacts() == null ? other.getContacts() == null : this.getContacts().equals(other.getContacts()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getTel() == null ? other.getTel() == null : this.getTel().equals(other.getTel()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getWechat() == null ? other.getWechat() == null : this.getWechat().equals(other.getWechat()))
            && (this.getInputtime() == null ? other.getInputtime() == null : this.getInputtime().equals(other.getInputtime()))
            && (this.getInputuserId() == null ? other.getInputuserId() == null : this.getInputuserId().equals(other.getInputuserId()))
            && (this.getSellerId() == null ? other.getSellerId() == null : this.getSellerId().equals(other.getSellerId()))
            && (this.getJobId() == null ? other.getJobId() == null : this.getJobId().equals(other.getJobId()))
            && (this.getSalarylevelId() == null ? other.getSalarylevelId() == null : this.getSalarylevelId().equals(other.getSalarylevelId()))
            && (this.getCustomersourceId() == null ? other.getCustomersourceId() == null : this.getCustomersourceId().equals(other.getCustomersourceId()))
            && (this.getCustomerstatusId() == null ? other.getCustomerstatusId() == null : this.getCustomerstatusId().equals(other.getCustomerstatusId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPool() == null ? other.getPool() == null : this.getPool().equals(other.getPool()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getContacts() == null) ? 0 : getContacts().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getTel() == null) ? 0 : getTel().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getWechat() == null) ? 0 : getWechat().hashCode());
        result = prime * result + ((getInputtime() == null) ? 0 : getInputtime().hashCode());
        result = prime * result + ((getInputuserId() == null) ? 0 : getInputuserId().hashCode());
        result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
        result = prime * result + ((getJobId() == null) ? 0 : getJobId().hashCode());
        result = prime * result + ((getSalarylevelId() == null) ? 0 : getSalarylevelId().hashCode());
        result = prime * result + ((getCustomersourceId() == null) ? 0 : getCustomersourceId().hashCode());
        result = prime * result + ((getCustomerstatusId() == null) ? 0 : getCustomerstatusId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPool() == null) ? 0 : getPool().hashCode());
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
        sb.append(", contacts=").append(contacts);
        sb.append(", age=").append(age);
        sb.append(", sex=").append(sex);
        sb.append(", tel=").append(tel);
        sb.append(", email=").append(email);
        sb.append(", qq=").append(qq);
        sb.append(", wechat=").append(wechat);
        sb.append(", inputtime=").append(inputtime);
        sb.append(", inputuserId=").append(inputuserId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", jobId=").append(jobId);
        sb.append(", salarylevelId=").append(salarylevelId);
        sb.append(", customersourceId=").append(customersourceId);
        sb.append(", customerstatusId=").append(customerstatusId);
        sb.append(", status=").append(status);
        sb.append(", pool=").append(pool);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}