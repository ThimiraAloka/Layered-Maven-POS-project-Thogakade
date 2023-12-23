package bo.Custom;

import bo.SuperBo;
import dto.ItemDto;

import java.sql.SQLException;
import java.util.List;

public interface ItemBo extends SuperBo {
    boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException;

    List<ItemDto> allItems() throws SQLException, ClassNotFoundException;

    ItemDto getItem(String string);
}
