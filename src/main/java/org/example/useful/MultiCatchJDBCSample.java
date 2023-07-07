package org.example.useful;

import java.sql.*;

public class MultiCatchJDBCSample {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("", "", "");
        return con;
    }

    public static void main(String[] args) {
        String sql = "select * from";
        try (
                Connection con = getConnection();
                PreparedStatement pstm = con.prepareStatement(sql);
                ResultSet result = pstm.executeQuery();
        ) {
            while (result.next()) {
                System.out.println(result.getString(1));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
