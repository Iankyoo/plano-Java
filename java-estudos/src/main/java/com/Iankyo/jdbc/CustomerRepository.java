package com.Iankyo.jdbc;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository {
    public void findAll(){
        String sql = "SELECT * FROM customers";

        try (Connection conn = DataBaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){

            while (rs.next()){
                System.out.println(
                        rs.getInt("customer_id") + " | " +
                        rs.getString("name")
                );
            }

        } catch (SQLException e){
            System.out.println("Database Error: " + e.getMessage());
        }

    }

    public void findById(int id){
        try(Connection conn = DataBaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT c.customer_id, c.name FROM customers c WHERE c.customer_id = ?")){

            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                System.out.println(
                        rs.getInt("customer_id") + " | " +
                        rs.getString("name") + " | "
                );
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    };

    public void saveAccount(String name, String email){
        try(Connection conn = DataBaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(" INSERT INTO customers (name, email) VALUES (?, ?)")
        ){
            stmt.setString(1,name);
            stmt.setString(2,email);
            stmt.executeUpdate();

            System.out.println("Account created");

        } catch (SQLException e){
            System.out.println("Database error: " + e.getMessage());
        }
    };

    public void deleteAccount(int id){
        try(Connection conn = DataBaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM customers WHERE customer_id =?")
        ){
            stmt.setInt(1,id);
            stmt.executeUpdate();

            System.out.println("Account has been deleted");

        } catch(SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
