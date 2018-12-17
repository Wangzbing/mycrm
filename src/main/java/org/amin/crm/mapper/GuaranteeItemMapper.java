package org.amin.crm.mapper;

import java.util.List;
import org.amin.crm.domain.GuaranteeItem;

public interface GuaranteeItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GuaranteeItem record);

    GuaranteeItem selectByPrimaryKey(Long id);

    List<GuaranteeItem> selectAll();

    int updateByPrimaryKey(GuaranteeItem record);
}