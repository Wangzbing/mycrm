package org.amin.crm.service;

import org.amin.crm.query.BaseQuery;
import org.amin.crm.utils.Page;

import java.io.Serializable;
import java.util.List;

/**
 * @author Amin
 * @Create 2018-11-29 0:21
 */
public interface IBaseService<T,ID extends Serializable> {
    void insert(T t);

    void delete(ID id);

    void update(T t);

    T findOne(ID id);

    List<T> findAll();

    Page<T> findByQuery(BaseQuery query);
}
