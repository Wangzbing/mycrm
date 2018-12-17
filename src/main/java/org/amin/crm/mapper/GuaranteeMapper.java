package org.amin.crm.mapper;

import java.util.List;
import org.amin.crm.domain.Guarantee;

public interface GuaranteeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Guarantee record);

    Guarantee selectByPrimaryKey(Long id);

    List<Guarantee> selectAll();

    int updateByPrimaryKey(Guarantee record);
}