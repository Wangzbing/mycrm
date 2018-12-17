package org.amin.crm.domain;

import org.amin.crm.utils.EasyuiColumn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Department implements Serializable {
    @EasyuiColumn(title = "部门id")
    private Long id;
    @EasyuiColumn(title = "部门名称")
    private String name;
    private String sn;

    private String dirpath;

    private Integer status;

    private Employee manager;

    private List<Department> children =new ArrayList<>();

    private static final long serialVersionUID = 1L;
    /*解决easyuitree*/
    public String getText(){
        return name;
    }


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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getDirpath() {
        return dirpath;
    }

    public void setDirpath(String dirpath) {
        this.dirpath = dirpath == null ? null : dirpath.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", sn=").append(sn);
        sb.append(", dirpath=").append(dirpath);
        sb.append(", status=").append(status);
        sb.append(", manager=").append(manager);
        sb.append(", children=").append(children);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}