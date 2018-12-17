package org.amin.crm.mapper;

import java.util.List;
import org.amin.crm.domain.ContractItem;

public interface ContractItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContractItem record);

    ContractItem selectByPrimaryKey(Long id);

    List<ContractItem> selectAll();

    int updateByPrimaryKey(ContractItem record);
}