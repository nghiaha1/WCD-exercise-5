package com.wcd.excercise5.model;

import com.wcd.excercise5.entity.Phone;
import com.wcd.excercise5.entity.myenum.PhoneStatus;
import com.wcd.excercise5.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlPhoneModel implements PhoneModel{

    @Override
    public Phone add(Phone obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into phones " +
                    "(id, name, brand, description, price, createdAt, updatedAt, status) " +
                    "values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, obj.getId());
            preparedStatement.setString(2, obj.getName());
            preparedStatement.setString(3, obj.getBrand());
            preparedStatement.setString(4, obj.getDescription());
            preparedStatement.setDouble(5, obj.getPrice());
            preparedStatement.setString(6, obj.getCreatedAt().toString());
            preparedStatement.setString(7, obj.getUpdatedAt().toString());
            preparedStatement.setInt(8, obj.getStatus().getValue());
            preparedStatement.execute();
            System.out.println("Action success!");
            return obj;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Phone> findAll() {
        List<Phone> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from phones where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, PhoneStatus.ACTIVE.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus = resultSet.getInt("status");
                Phone obj = new Phone();
                obj.setId(id);
                obj.setName(name);
                obj.setDescription(description);
                obj.setPrice(price);
                obj.setCreatedAt(createdAt);
                obj.setUpdatedAt(updatedAt);
                obj.setStatus(PhoneStatus.of(intStatus));
                list.add(obj);
            }
            System.out.println("Action success!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
