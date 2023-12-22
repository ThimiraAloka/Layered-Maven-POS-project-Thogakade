package bo.custom.impl;

import bo.custom.CustomerBo;
import dto.CustomerDto;

public class CustomerBoImpl implements CustomerBo<CustomerDto> {
    @Override
    public boolean saveCustomer(CustomerDto dto) {
        return false;
    }
}
