/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assist.controller;

import assist.common.DBConnection;
import assist.model.status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class statusDAO {
    public void insertData(status ab){         //insert for daily
 try{
     Connection con=DBConnection.getConnection();
     String sql="insert into status (expenses,type,price)values(?,?,?)";
     PreparedStatement pst=con.prepareStatement(sql);
     pst.setString(1, ab.getExpenses());
     pst.setString(2,ab.getType());
     pst.setDouble(3,ab.getPrice());
     pst.executeUpdate();
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
}
    
    
    public ArrayList<status> fetchData(){         //fetch for daily
        ArrayList<status> list = new ArrayList();
 try{
     Connection con=DBConnection.getConnection();
     String sql="select * from status order by type";
     Statement st = con.createStatement();
     ResultSet rs = st.executeQuery(sql);
     while(rs.next()){
         status ob =new status();
         ob.setSid(rs.getInt("sid"));
         ob.setExpenses(rs.getString("expenses"));
         ob.setType(rs.getString("type"));
         ob.setPrice(rs.getDouble("price"));         
         
         list.add(ob);
     }
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
     return list;   
    }
    
    public ArrayList<status> fetchData_dtotal(){         //fetch for daily
        ArrayList<status> list = new ArrayList();
 try{
     Connection con=DBConnection.getConnection();
     String sql="select * from status where type='Daily'";
     Statement st = con.createStatement();
     ResultSet rs = st.executeQuery(sql);
     while(rs.next()){
         status ob =new status();
         ob.setPrice(rs.getDouble("price"));         
         list.add(ob);
     }
     con.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
     return list;   
    }
    public ArrayList<status> fetchData_mtotal(){         //fetch for daily
        ArrayList<status> list = new ArrayList();
 try{
     Connection con=DBConnection.getConnection();
     String sql="select * from status where type='Monthly'";
     Statement st = con.createStatement();
     ResultSet rs = st.executeQuery(sql);
     while(rs.next()){
         status ob =new status();
         ob.setPrice(rs.getDouble("price"));         
         list.add(ob);
     }
     con.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
     return list;   
    }
    public ArrayList<status> fetchData_utotal(){         //fetch for daily
        ArrayList<status> list = new ArrayList();
 try{
     Connection con=DBConnection.getConnection();
     String sql="select * from status where type='unexpectedly'";
     Statement st = con.createStatement();
     ResultSet rs = st.executeQuery(sql);
     while(rs.next()){
         status ob =new status();
         ob.setPrice(rs.getDouble("price"));         
         list.add(ob);
     }
     con.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
     return list;   
    }
    
    public void updateData(status ab){           //daily update
 try{
     Connection con=DBConnection.getConnection();
     String sql="update status set expenses=?, type=?, price=? where rid=?";
     PreparedStatement pst=con.prepareStatement(sql);
     pst.setString(1,ab.getExpenses());
     pst.setString(2,ab.getType());
     pst.setDouble(3,ab.getPrice());
     pst.setInt(4,ab.getSid());
     pst.executeUpdate();
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    
    public void deleteData(status ab){     //daily delete
 try{
     Connection con=DBConnection.getConnection();
     String sql="delete from status where sid=?";
     PreparedStatement pst=con.prepareStatement(sql);
     pst.setInt(1, ab.getSid());
     pst.executeUpdate();
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    
    
    public void clearAll(){    //daily clear
 try{
     Connection con=DBConnection.getConnection();
     String sql="delete from status";
     PreparedStatement pst=con.prepareStatement(sql);
     pst.executeUpdate();
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
}
