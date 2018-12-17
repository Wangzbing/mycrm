package org.amin.crm.mapper;

import java.util.List;
import org.amin.crm.domain.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    Resource selectByPrimaryKey(Long id);

    List<Resource> selectAll();

    int updateByPrimaryKey(Resource record);
}