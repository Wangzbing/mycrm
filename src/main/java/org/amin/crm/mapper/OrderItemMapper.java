package org.amin.crm.mapper;

import java.util.List;
import org.amin.crm.domain.OrderItem;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderItem record);

    OrderItem selectByPrimaryKey(Long id);

    List<OrderItem> selectAll();

    int updateByPrimaryKey(OrderItem record);
}