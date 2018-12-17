package org.amin.crm.mapper;

import java.util.List;
import org.amin.crm.domain.CostomerTransfer;

public interface CostomerTransferMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CostomerTransfer record);

    CostomerTransfer selectByPrimaryKey(Long id);

    List<CostomerTransfer> selectAll();

    int updateByPrimaryKey(CostomerTransfer record);
}