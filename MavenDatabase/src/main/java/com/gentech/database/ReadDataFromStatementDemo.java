package com.gentech.database;

import java.sql.*;

public class ReadDataFromStatementDemo {
    public static void main(String[] args) {
     //   readDatabaseTableContent();
    //    insertRecordsInToTable();
     //   deleteRecordInToTable();
        updateRecordInToTable();
    }

    private static void readDatabaseTableContent()
    {
        Connection conn=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gentechdb","root","root");
            Statement stmt=conn.createStatement();
            String query="select * from dept";
            ResultSet rs=stmt.executeQuery(query);
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
            Statement stmt=conn.createStatement();
            String query="insert into dept values(50,'HEALTH','BANGALORE')";
            int v1=stmt.executeUpdate(query);

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

    private static void deleteRecordInToTable()
    {
        Connection conn=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gentechdb","root","root");
            Statement stmt=conn.createStatement();
            String query="delete from dept where DEPTNO=50";
            int v1=stmt.executeUpdate(query);

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

    private static void updateRecordInToTable()
    {
        Connection conn=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gentechdb","root","root");
            Statement stmt=conn.createStatement();
            String query="update dept set LOC='MANGALORE' where DEPTNO=60";
            int v1=stmt.executeUpdate(query);

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
