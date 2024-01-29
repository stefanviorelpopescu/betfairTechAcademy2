package org.example.databases;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Main {
    public static void main(String[] args)
    {
        try
        {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            DriverManager.setLoginTimeout(60); // wait 1 min; optional: DB may be busy, good to set a higher timeout
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException e){
            System.err.println("Can’t load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        } catch (InvocationTargetException e)
        {
            throw new RuntimeException(e);
        }

        String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=root";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement("select * from authors");
             ResultSet resultSet = ps.executeQuery())
        {
            while(resultSet.next())
            {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String phone = resultSet.getString("phone");
                System.out.printf("%s\t%d\t%s%n", name, age, phone);
            }

        } catch (SQLException e)
        {
            System.err.println("Cannot connect to the database: " + e.getMessage());
        }
    }
}
