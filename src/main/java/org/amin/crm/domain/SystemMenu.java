package org.amin.crm.domain;

import org.amin.crm.utils.EasyuiColumn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SystemMenu implements Serializable {

    @EasyuiColumn(title = "菜单编号")
    private Long id;
    @EasyuiColumn(title = "菜单名称")
    private String name;
    @EasyuiColumn(title = "菜单资源")
    private String url;
    @EasyuiColumn(title = "菜单简介")
    private String sn;
    @EasyuiColumn(title = "菜单图标")
    private String icon;
    @EasyuiColumn(title = "菜单介绍")
    private String intro;

    @EasyuiColumn(title = "父级菜单")
    private SystemMenu parent;
    /*子集菜单*/
    private List<SystemMenu> children = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public SystemMenu getParent() {
        return parent;
    }
    public String getText(){
        return name;
    }

    public void setParent(SystemMenu parent) {
        this.parent = parent;
    }

    public List<SystemMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SystemMenu> children) {
        this.children = children;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
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
        sb.append(", url=").append(url);
        sb.append(", icon=").append(icon);
        sb.append(", intro=").append(intro);
        sb.append(", parent=").append(parent);
        sb.append(", children=").append(children);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}