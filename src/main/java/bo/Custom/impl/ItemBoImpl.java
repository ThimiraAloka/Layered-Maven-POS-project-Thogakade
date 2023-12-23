package bo.Custom.impl;

import bo.Custom.ItemBo;
import dao.DaoFactory;
import dao.custom.CustomerDao;
import dao.custom.ItemDao;
import dao.custom.impl.CustomerDaoImpl;
import dao.custom.impl.ItemDaoImpl;
import dao.util.DaoType;
import dto.CustomerDto;
import dto.ItemDto;
import entity.Customer;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBoImpl implements ItemBo {
    private ItemDao itemDao = DaoFactory.getInstance().getDao(DaoType.ITEM);
    @Override
    public boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return itemDao.update(new Item(
                dto.getCode(),
                dto.getDesc(),
                dto.getUnitPrice(),
                dto.getQty()
        ));
    }

    @Override
    public List<ItemDto> allItems() throws SQLException, ClassNotFoundException {
        List<Item> entityList =  itemDao.getAll();
        List<ItemDto> list = new ArrayList<>();
        for (Item item: entityList) {
            list.add(new ItemDto(
                    item.getCode(),
                    item.getDesc(),
                    item.getUnitPrice(),
                    item.getQty()
            ));
        }
        return list;
    }

    @Override
    public ItemDto getItem(String string) {
        return null;
    }
}
