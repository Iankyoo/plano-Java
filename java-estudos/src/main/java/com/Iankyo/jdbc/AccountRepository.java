package com.Iankyo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository {
    public void findCustomerById(int id){
        try(Connection conn = DataBaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM accounts WHERE customer_id = ?")
        ){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                System.out.println(
                        rs.getInt("customer_id") + " | " +
                        rs.getString("account_type") + " | " +
                        rs.getDouble("balance")
                );
            }

        } catch (SQLException e){
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public void transfer(int fromId, int toId, double amount){
        try (Connection conn = DataBaseConnection.getConnection()){
            conn.setAutoCommit(false);

            try (PreparedStatement debit = conn.prepareStatement(" UPDATE accounts SET balance = balance - ? WHERE account_id = ?");
                 PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE account_id = ?")){

                debit.setDouble(1, amount);
                debit.setInt(2, fromId);
                debit.executeUpdate();

                credit.setDouble(1, amount);
                credit.setInt(2, toId);
                credit.executeUpdate();

                conn.commit();
                System.out.println("Transfer completed successfully");
            } catch (SQLException e){
                conn.rollback();
                System.out.println("Database error: " + e.getMessage());
            }
        } catch (SQLException e){
            System.out.println("Database error: " + e.getMessage());
        }
    }
}

