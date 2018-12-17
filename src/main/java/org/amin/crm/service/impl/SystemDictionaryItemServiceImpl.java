package org.amin.crm.service.impl;

import org.amin.crm.domain.SystemDictionaryItem;
import org.amin.crm.mapper.SystemDictionaryItemMapper;
import org.amin.crm.service.ISystemDictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Amin
 * @Create 2018-11-29 0:37
 */

@Service
public class SystemDictionaryItemServiceImpl extends BaseServiceImpl<SystemDictionaryItem,Long> implements ISystemDictionaryItemService {
    @Autowired
    private SystemDictionaryItemMapper systemDictionaryItemMapper;
    @Override
    public void leftAndRe(Long id) {
        if (systemDictionaryItemMapper.findOne(id).getStatus() == 1) {
            systemDictionaryItemMapper.left(id);
        } else {
            systemDictionaryItemMapper.rework(id);
        }
    }
}
