package com.example.ecommerce;

import java.sql.ResultSet;

public class login {

    public Customer customerLogin(String userName, String password) {
        String loginQuery = "select * from customer where email = '" + userName + "'  AND password='" + password + "'";
        DbConnection conn = new DbConnection();
        ResultSet rs = conn.getQueryTable(loginQuery);
        try {
            if (rs.next()) {
                return new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
                        rs.getString("mobile"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        login Login = new login();
        Customer customer = Login.customerLogin("rona@gmail.com","abc123");
        System.out.println("Welcome : "+customer.getName());
    }
}

