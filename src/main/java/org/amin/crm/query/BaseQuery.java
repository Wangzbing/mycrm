package org.amin.crm.query;

/**
 * @author Amin
 * @Create 2018-11-29 0:16
 */
public class BaseQuery {
    //当前页
    private Integer page;
    //页面总数
    private Integer rows;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
