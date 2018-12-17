package org.amin.crm.query;

import org.amin.crm.domain.Department;

/**
 * @author Amin
 * @Create 2018-11-29 0:18
 */
public class EmployeeQuery extends BaseQuery {

    private String realName;

    private Integer department_id;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }
}
