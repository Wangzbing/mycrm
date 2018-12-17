package org.amin.crm.domain;

import org.amin.crm.utils.EasyuiColumn;

import java.io.Serializable;

public class SystemDictionaryItem implements Serializable {
    @EasyuiColumn(title = "明细id")
    private Long id;
    @EasyuiColumn(title = "明细名称")
    private String name;
    @EasyuiColumn(title = "明细序列号")
    private Integer sequence;
    @EasyuiColumn(title = "明细状态")
    private Integer status;
    @EasyuiColumn(title = "明细简介")
    private String intro;
    @EasyuiColumn(title = "明细类型")
    private SystemDictionaryType type;

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

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public SystemDictionaryType getType() {
        return type;
    }

    public void setType(SystemDictionaryType type) {
        this.type = type;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", sequence=").append(sequence);
        sb.append(", status=").append(status);
        sb.append(", intro=").append(intro);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}