package org.amin.crm.mapper;

import org.amin.crm.query.BaseQuery;

import java.io.Serializable;
import java.util.List;

/**
 * @author Amin
 * @Create 2018-11-29 0:21
 */
public interface BaseMapper<T,ID extends Serializable> {
    void insert(T t);

    void delete(ID id);

    void update(T t);

    T findOne(ID id);

    List<T> findAll();

    List<T> findByQuery(BaseQuery query);
}
