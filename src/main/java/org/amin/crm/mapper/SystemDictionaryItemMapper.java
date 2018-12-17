package org.amin.crm.mapper;

import java.util.List;
import org.amin.crm.domain.SystemDictionaryItem;

public interface SystemDictionaryItemMapper extends BaseMapper<SystemDictionaryItem,Long>{

    void left(Long id);

    void rework(Long id);
}