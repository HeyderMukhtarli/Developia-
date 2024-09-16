package Ders17;

import java.sql.*;

public class DatabaeConnection<ResultSet> {
    public static void main(String[] args) {
        try{

            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/resume","root","admin");
            Statement stmt=con.createStatement();
            PreparedStatement ps=con.prepareStatement("update user set name=? where id=15");
            ps.setString(1, "update2");
            ps.executeUpdate();
            java.sql.ResultSet rs=stmt.executeQuery("select * from user");
            while(rs.next())
                System.out.println(rs.getString(1)+rs.getString(2)+"  "+rs.getString(3));
        }catch(Exception e){ e.printStackTrace();}
    }
    }
