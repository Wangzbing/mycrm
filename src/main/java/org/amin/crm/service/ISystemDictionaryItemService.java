package org.amin.crm.service;

import org.amin.crm.domain.SystemDictionaryItem;
import org.amin.crm.service.IBaseService;

import java.util.List;

/**
 * @author Amin
 * @Create 2018-11-29 0:36
 */
public interface ISystemDictionaryItemService extends IBaseService<SystemDictionaryItem,Long> {

    void leftAndRe(Long id);
}
