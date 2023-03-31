package com.spittr.spittr_app.repositories;

import com.spittr.spittr_app.configuration.ConnectionFactory;
import com.spittr.spittr_app.models.Spittle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public static class SpittleJDBCRepository {
    private ConnectionFactory connectionFactory;
    private Connection connection;

    public SpittleJDBCRepository() {
        System.out.println("SpittleJDBCRepository.constructor");
        connectionFactory = new ConnectionFactory();
        connection = connectionFactory.getConnection();
    }

    public void createSpittle(String message, String time, Double longitude, Double latitude) {
        System.out.println("SpittleJDBCRepository.createSpittle");
        try {
            /*Create an ID incremental*/
            Long id = -1000L;
            /* if(this.getMaxId()) then id = this.getMaxId() + 1; */
            /* else message and return */
//             id = this.getMaxId() + 1;
            PreparedStatement ps = connection.prepareStatement("INSERT INTO spittle (id, message, time, longitude, latitude) VALUES (?, ?, ?, ?, ?);");
            ps.setLong(1, id);
            ps.setString(2, message);
            ps.setString(3, time);
            ps.setDouble(4, longitude);
            ps.setDouble(5, latitude);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Spittle getSpittleById(Long id) {
        System.out.println("SpittleJDBCRepository.getSpittleById");
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM spittle WHERE id=?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                Spittle spittle = new Spittle();
                spittle.setId( rs.getLong("id") );
                spittle.setMessage( rs.getString("message") );
                spittle.setTime( rs.getString("time") );
                spittle.setLongitude( rs.getDouble("longitude") );
                spittle.setLatitude( rs.getDouble("latitude") );
                return spittle;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public void updateSpittleMessageById(Long id, String message) {
        System.out.println("SpittleJDBCRepository.updateSpittleMessageById");
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE spittle SET message=? where id = ?;");
            ps.setString(1, message);
            ps.setLong(2, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteSpittleById(Long id) {
        System.out.println("SpittleJDBCRepository.deleteSpittleById");
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE from spittle where id = ?;");
            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Long getMaxId(){
        System.out.println("SpittleJDBCRepository.getMaxId");
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT max(id) as maxId FROM spittle");
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getLong("maxId");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

