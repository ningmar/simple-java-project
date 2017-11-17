
package assist.controller;

import assist.common.DBConnection;
import assist.model.event;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class eventDAO {
    public void insertData(event ab){
 try{
     Connection con=DBConnection.getConnection();
     String sql="insert into events (date,time,description)values(?,?,?)";
     PreparedStatement pst=con.prepareStatement(sql);
     pst.setString(1, ab.getMydate());
     pst.setString(2,ab.getMytime());
     pst.setString(3,ab.getDescription());
     pst.executeUpdate();
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
}
    public ArrayList<event> fetchData(){
        ArrayList<event> list = new ArrayList();
 try{
     Connection con=DBConnection.getConnection();
     String sql="select * from events order by date asc";
     Statement st = con.createStatement();
     ResultSet rs = st.executeQuery(sql);
     while(rs.next()){
         event ob =new event();
         ob.setId(rs.getInt("eid"));
         ob.setMydate(rs.getString("date"));
         ob.setMytime(rs.getString("time"));
         ob.setDescription(rs.getString("description"));
         
         list.add(ob);
     }
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
     return list;   
    }
    public void updateData(event ab){
 try{
     Connection con=DBConnection.getConnection();
     String sql="update events set date=?, time=?, description=? where eid=?";
     PreparedStatement pst=con.prepareStatement(sql);
     pst.setString(1,ab.getMydate());
     pst.setString(2,ab.getMytime());
     pst.setString(3,ab.getDescription());
     pst.setInt(4,ab.getId());
     pst.executeUpdate();
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    public void deleteData(event ab){
 try{
     Connection con=DBConnection.getConnection();
     String sql="delete from events where eid=?";
     PreparedStatement pst=con.prepareStatement(sql);
     pst.setInt(1, ab.getId());
     pst.executeUpdate();
     con.close();
     
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
}
