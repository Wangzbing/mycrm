package org.amin.crm.domain;

import org.amin.crm.utils.EasyuiColumn;

import java.io.Serializable;
import java.util.Date;
/*日志的pojo*/
public class SystemLog implements Serializable {
    @EasyuiColumn(title = "日志id")
    private Long id;
    @EasyuiColumn(title = "操作人")
    private Employee opuser;
    @EasyuiColumn(title = "操作时间")
    private Date optime;
    @EasyuiColumn(title = "操作ip")
    private String opip;
    @EasyuiColumn(title = "操作方法")
    private String function;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getOpuser() {
        return opuser;
    }

    public void setOpuser(Employee opuser) {
        this.opuser = opuser;
    }

    public Date getOptime() {
        return optime;
    }

    public void setOptime(Date optime) {
        this.optime = optime;
    }

    public String getOpip() {
        return opip;
    }

    public void setOpip(String opip) {
        this.opip = opip == null ? null : opip.trim();
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function == null ? null : function.trim();
    }

}