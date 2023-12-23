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
    public String generateId() throws SQLException, ClassNotFoundException {
        try {
            String id = orderDao.lastOrder().getOrderId();
            if (id != null) {
                int num = Integer.parseInt(id.split("[D]")[1]);
                num++;
                return String.format("D%03d", num);
            } else {
                return "D001";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }


}
