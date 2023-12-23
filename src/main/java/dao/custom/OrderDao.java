package dao.custom;

import dao.CrudDao;
import dto.OrderDto;
import entity.Orders;

import java.sql.SQLException;

public interface OrderDao extends CrudDao<OrderDto> {
   OrderDto lastOrder() throws SQLException, ClassNotFoundException;
   //boolean saveOrder(Orders entity) throws SQLException, ClassNotFoundException;

}
