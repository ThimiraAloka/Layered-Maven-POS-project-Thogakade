package dao.custom.impl;

import db.DBConnection;
import dto.ItemDto;
import dao.custom.ItemDao;
import entity.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

    @Override
    public ItemDto getItem(String code) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM item WHERE code=?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1,code);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            return new ItemDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );
        }
        return null;
    }

/////////////////////////////////////////////////////////////////////////
    @Override
    public boolean save(Item entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE item SET qtyOnHand=?, description=?, unitPrice=? WHERE code=? ";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(4,entity.getCode());
        pstm.setString(2,entity.getDesc());
        pstm.setDouble(3,entity.getUnitPrice());
        pstm.setInt(1,entity.getQty());

        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Item> getAll() throws SQLException, ClassNotFoundException {
        List<Item> list = new ArrayList<>();
        String sql = "SELECT * FROM item";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()){
            list.add(new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            ));
        }
        return list;
    }
}
