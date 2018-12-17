package org.amin.crm.mapper;

import java.util.List;
import org.amin.crm.domain.Contract;

public interface ContractMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Contract record);

    Contract selectByPrimaryKey(Long id);

    List<Contract> selectAll();

    int updateByPrimaryKey(Contract record);
}