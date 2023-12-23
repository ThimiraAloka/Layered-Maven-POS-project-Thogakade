package bo.Custom;

import bo.SuperBo;
import dto.OrderDto;

import java.sql.SQLException;

public interface OrderBo extends SuperBo {
    boolean saveOrder(OrderDto dto) throws SQLException,ClassNotFoundException;
    OrderDto lastOrder() throws SQLException, ClassNotFoundException;
}