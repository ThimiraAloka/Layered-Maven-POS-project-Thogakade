package bo.Custom;

import bo.SuperBo;
import dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBo <T> extends SuperBo {
    boolean saveCustomer(T dto) throws SQLException, ClassNotFoundException;

    List<CustomerDto> allCustomers() throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(T dto) throws SQLException, ClassNotFoundException;
}