package org.amin.crm.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Amin
 * @Create 2018-11-29 1:02
 */
public class Page<T> {

   private List<T> list=new ArrayList<>();
   private Integer total;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
