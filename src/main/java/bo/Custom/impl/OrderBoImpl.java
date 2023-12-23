package bo.Custom.impl;

import bo.Custom.ItemBo;
import bo.Custom.OrderBo;
import dao.custom.OrderDao;
import dao.custom.impl.OrderDaoImpl;
import dto.OrderDto;

import java.sql.SQLException;

public class OrderBoImpl implements OrderBo {
    private OrderDao orderDao = new OrderDaoImpl();
   @Override
    public boolean saveOrder(OrderDto dto) throws SQLException, ClassNotFoundException {
        return orderDao.save(dto);
    }

    @Override
    public OrderDto lastOrder() throws SQLException, ClassNotFoundException {
        return orderDao.lastOrder();
    }
}
