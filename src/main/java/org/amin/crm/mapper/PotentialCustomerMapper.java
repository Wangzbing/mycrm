package org.amin.crm.mapper;

import java.util.List;
import org.amin.crm.domain.PotentialCustomer;

public interface PotentialCustomerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PotentialCustomer record);

    PotentialCustomer selectByPrimaryKey(Long id);

    List<PotentialCustomer> selectAll();

    int updateByPrimaryKey(PotentialCustomer record);
}