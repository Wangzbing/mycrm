package org.amin.crm.mapper;

import java.util.List;
import org.amin.crm.domain.Costomer;

public interface CostomerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Costomer record);

    Costomer selectByPrimaryKey(Long id);

    List<Costomer> selectAll();

    int updateByPrimaryKey(Costomer record);
}