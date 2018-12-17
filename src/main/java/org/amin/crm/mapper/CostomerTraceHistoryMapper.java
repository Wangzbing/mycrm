package org.amin.crm.mapper;

import java.util.List;
import org.amin.crm.domain.CostomerTraceHistory;

public interface CostomerTraceHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CostomerTraceHistory record);

    CostomerTraceHistory selectByPrimaryKey(Long id);

    List<CostomerTraceHistory> selectAll();

    int updateByPrimaryKey(CostomerTraceHistory record);
}