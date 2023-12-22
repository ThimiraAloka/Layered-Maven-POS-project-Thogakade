package bo.custom;

import dao.SuperDao;

public interface CustomerBo <T> extends SuperDao {
    boolean saveCustomer(T dto);
}
