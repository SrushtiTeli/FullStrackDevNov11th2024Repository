package com.gentech.database;

import java.sql.*;

public class ReadDataFromPreparedStatementDemo {
    public static void main(String[] args) {
        readDatabaseTableContent();
      // insertRecordsInToTable();
       // deleteRecordInTable();
    }

    private static void readDatabaseTableContent()
    {
        Connection conn=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/gentechdb","root","root");
            String query="select * from dept";
            PreparedStatement stmt=conn.prepareStatement(query);
            ResultSet rs=stmt.executeQuery();
            ResultSetMetaData rsdata =rs.getMetaData();
            String col1=rsdata.getColumnName(1);
            String col2=rsdata.getColumnName(2);
            String col3=rsdata.getColumnName(3);
            System.out.printf("%-12s",col1);
            System.out.printf("%-12s",col2);
            System.out.printf("%-12s",col3);
            System.out.printf("\n");
            while(rs.next())
            {
                String deptno=rs.getString("DEPTNO");
                String deptname=rs.getString("DNAME");
                String place=rs.getString("LOC");
                System.out.printf("%-12s",deptno);
                System.out.printf("%-12s",deptname);
                System.out.printf("%-12s",place);
                System.out.printf("\n");
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    private static void insertRecordsInToTable()
    {
        Connection conn=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gentechdb","root","root");
            String query="insert into dept values(60,'INSURANCE','MYSORE')";
            PreparedStatement stmt=conn.prepareStatement(query);
            int v1=stmt.executeUpdate();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    private static void deleteRecordInTable()
    {
        Connection conn=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gentechdb","root","root");
            String query="delete from dept where DEPTNO=10";
            PreparedStatement stmt=conn.prepareStatement(query);
            int v1=stmt.executeUpdate();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
