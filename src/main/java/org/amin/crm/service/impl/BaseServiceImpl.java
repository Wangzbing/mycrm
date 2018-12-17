package org.amin.crm.service.impl;

import com.github.pagehelper.PageHelper;
import org.amin.crm.domain.Department;
import org.amin.crm.mapper.BaseMapper;
import org.amin.crm.query.BaseQuery;
import org.amin.crm.service.IBaseService;
import org.amin.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author Amin
 * @Create 2018-11-29 0:31
 */
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class BaseServiceImpl<T,ID extends Serializable> implements IBaseService<T,ID> {

    @Autowired
    private BaseMapper<T,ID>  baseMapper;
    @Transactional
    @Override
    public void insert(T t) {
        baseMapper.insert(t);
    }
    @Transactional
    @Override
    public void delete(ID id) {
        baseMapper.delete(id);
    }

    @Transactional
    @Override
    public void update(T t){
        baseMapper.update(t);
    }

    @Override
    public T findOne(ID id) {
        return baseMapper.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return baseMapper.findAll();
    }

    @Override
    public Page<T> findByQuery(BaseQuery query) {
        com.github.pagehelper.Page<Object> objectPage = PageHelper.startPage(query.getPage(), query.getRows());
        List<T> queryList = baseMapper.findByQuery(query);
        Page page = new Page();
        page.setList(queryList);
        page.setTotal((int) objectPage.getTotal());
        return page;
    }

}
