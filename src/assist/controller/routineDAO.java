
package assist.controller;

import assist.common.DBConnection;
import assist.model.event;
import assist.model.routine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class routineDAO {
    public void insertData(routine ab){         //insert for daily
 try{
     Connection con=DBConnection.getConnection();
     String sql="insert into routine (starttime,endtime,activity,reference)values(?,?,?,?)";
     PreparedStatement pst=con.prepareStatement(sql);
     pst.setString(1, ab.getStarttime());
     pst.setString(2,ab.getEndtime());
     pst.setString(3,ab.getActivity());
     pst.setString(4,ab.getReference());
     pst.executeUpdate();
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
}
    
    
    public ArrayList<routine> fetchData(){         //fetch for daily
        ArrayList<routine> list = new ArrayList();
 try{
     Connection con=DBConnection.getConnection();
     String sql="select * from routine where reference=0 order by starttime asc";
     Statement st = con.createStatement();
     ResultSet rs = st.executeQuery(sql);
     while(rs.next()){
         routine ob =new routine();
         ob.setId(rs.getInt("rid"));
         ob.setStarttime(rs.getString("starttime"));
         ob.setActivity(rs.getString("activity"));
         ob.setEndtime(rs.getString("endtime"));         
         
         list.add(ob);
     }
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
     return list;   
    }
    
    public ArrayList<routine> fetchData_holi(){
        ArrayList<routine> list = new ArrayList();
 try{
     Connection con=DBConnection.getConnection();
     String sql="select * from routine where reference=1 order by starttime asc";
     Statement st = con.createStatement();
     ResultSet rs = st.executeQuery(sql);
     while(rs.next()){
         routine ob =new routine();
         ob.setId(rs.getInt("rid"));
         ob.setStarttime(rs.getString("starttime"));
         ob.setActivity(rs.getString("activity"));
         ob.setEndtime(rs.getString("endtime"));         
         
         list.add(ob);
     }
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
     return list;   
    }
    
    public ArrayList<routine> fetchData_ran(){//fetching random 
        ArrayList<routine> list = new ArrayList();
 try{
     Connection con=DBConnection.getConnection();
     String sql="select * from routine where reference=2 order by starttime asc";
     Statement st = con.createStatement();
     ResultSet rs = st.executeQuery(sql);
     while(rs.next()){
         routine ob =new routine();
         ob.setId(rs.getInt("rid"));
         ob.setStarttime(rs.getString("starttime"));
         ob.setActivity(rs.getString("activity"));
         ob.setEndtime(rs.getString("endtime"));         
         
         list.add(ob);
     }
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
     return list;   
    }
    
    public void updateData(routine ab){           //daily update
 try{
     Connection con=DBConnection.getConnection();
     String sql="update routine set starttime=?, endtime=?, activity=? where rid=?";
     PreparedStatement pst=con.prepareStatement(sql);
     pst.setString(1,ab.getStarttime());
     pst.setString(2,ab.getEndtime());
     pst.setString(3,ab.getActivity());
     pst.setInt(4,ab.getId());
     pst.executeUpdate();
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    
    public void deleteData(routine ab){     //daily delete
 try{
     Connection con=DBConnection.getConnection();
     String sql="delete from routine where rid=?";
     PreparedStatement pst=con.prepareStatement(sql);
     pst.setInt(1, ab.getId());
     pst.executeUpdate();
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    
    
    public void clearAll(){    //daily clear
 try{
     Connection con=DBConnection.getConnection();
     String sql="delete from routine where reference='0'";
     PreparedStatement pst=con.prepareStatement(sql);
     pst.executeUpdate();
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    public void clearAll_holi(){      //holi clear
 try{
     Connection con=DBConnection.getConnection();
     String sql="delete from routine where reference='1'";
     PreparedStatement pst=con.prepareStatement(sql);
     pst.executeUpdate();
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    public void clearAll_ran(){      //random clear
 try{
     Connection con=DBConnection.getConnection();
     String sql="delete from routine where reference='2'";
     PreparedStatement pst=con.prepareStatement(sql);
     pst.executeUpdate();
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
}
