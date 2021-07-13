/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package travelmanagement;
import java.awt.*;
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static travelmanagement.TouristsInterface.jTextField4;
import static travelmanagement.connection.con;
 
public class TourTrip {

   

    public String getTripcategory() {
        return Tripcategory;
    }
     private String TripName;
     private String TripDate;
     private String Tripcategory;
     private TourGuide1 TourGuide;
     private int AvailableTicketsNum;
     private int JoiningTouristNum;
     private Site TripSite;
     private int Price;
 
    public void setTripName(String TripName) {
        this.TripName = TripName;
    }

     public void setTripcategory(String Tripcategory) {
        this.Tripcategory = Tripcategory;
    }
   
//    public void setTourGuide(int id) {
//        TourGuide.asign(id);
//    }
//    
//    public TourGuide1 getTourGuide(int id) {
//        return TourGuide.search(id);
//    }

    public void setAvailableTicketsNum(int AvailableTicketsNum) {
        this.AvailableTicketsNum = AvailableTicketsNum;
    }

    public void setJoiningTouristNum(int JoiningTouristNum) {
        this.JoiningTouristNum = JoiningTouristNum;
    }

    

    public void setTripSite(Site TripSite) {
        this.TripSite = TripSite;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getTripName() {
        return TripName;
    }

    public String getTripDate() {
        return TripDate;
    }

    public void setTripDate(String TripDate) {
        this.TripDate = TripDate;
    }

    

   


    public int getAvailableTicketsNum() {
        return AvailableTicketsNum;
    }

    public int getJoiningTouristNum() {
        return JoiningTouristNum;
    }

    

    public Site getTripSite() {
        return TripSite;
    }

    public int getPrice() {
        return Price;
    }

   
     
    public void AddTour(){
     try{
                connection.setConnection();
            connection.runNoNQuery("insert into trips"
                    +"(Trip_name,Trip_date,Trip_category,Tourguide_id,available_tickets,Site_name,Trip_price)"
            +"values('"+ToursInterface.jTextField2.getText()+"','"+ ToursInterface.jTextField3.getText()+"','"+ ToursInterface.jComboBox1.getSelectedItem().toString()+"','"+ ToursInterface.jTextField4.getText()+"','"+Integer.valueOf(ToursInterface.jTextField5.getText())+"','"+ToursInterface.jTextField15.getText()+"','"+Integer.valueOf(ToursInterface.jTextField1.getText())+"')");
            JOptionPane.showMessageDialog(null,"ADD successfully");
            }
            catch(Exception ex){
               JOptionPane.showMessageDialog(null,"Erorr in connection");
            }
    }
    
    
    
    public void EditTour(){
    try{
connection.setConnection();
String updateQuery = "UPDATE `trips` SET `Trip_date`=?,`Trip_category`=? ,`Tourguide_id`=? ,`available_tickets`=?,`Site_name`=? ,`Trip_price`=? where Trip_name=?";
  PreparedStatement p = connection.con.prepareStatement(updateQuery);
  p.setString(1,ToursInterface.jTextField8.getText());
  p.setString(2,ToursInterface.jComboBox2.getSelectedItem().toString());
  p.setInt(3,Integer.valueOf(ToursInterface.jTextField9.getText()));
  p.setInt(4,Integer.valueOf(ToursInterface.jTextField10.getText()));
  p.setString(5,ToursInterface.jTextField14.getText());
  p.setInt(6,Integer.valueOf(ToursInterface.jTextField7.getText()));
  p.setString(7, ToursInterface.jTextField6.getText());
  p.executeUpdate();
        connection.con.close();  
     JOptionPane.showMessageDialog(null,"Update successfully");
}


  catch(Exception ex){
           JOptionPane.showMessageDialog(null,ex);
  }

    
    }
    public void CancelTour(){
 try
{
           connection.setConnection();
           connection.runNoNQuery("delete from trips where Trip_name = " +ToursInterface.jTextField11.getText());
             JOptionPane.showMessageDialog(null,"Delete successfully"); 
    }
    catch(Exception ex){
              JOptionPane.showMessageDialog(null,ex);
    }
    
    }
    public void CalculateProfit(){
   
 try
       {
            connection.setConnection();
          
           // PreparedStatement ps=con.prepareStatement();
           Statement st1=con.createStatement();
           Statement st2=con.createStatement();
           Statement st=con.createStatement();
            ResultSet rs2 = st1.executeQuery("SELECT Trip_name FROM trips");
            ResultSet rs3 = st2.executeQuery("SELECT Trip_price FROM trips");
            ArrayList<String> tripname=new ArrayList<>();
            ArrayList<Integer> tripprice=new ArrayList<>();
            ArrayList<Integer>Joining_tourist_snum=new ArrayList<>();
            int totalProfit = 0;
            while(rs2.next())
            {
                tripname.add(rs2.getString("Trip_name"));
            }
             while(rs3.next())
            {
                tripprice.add(rs3.getInt("Trip_price"));
            }
            
           for(int i=0;i<tripname.size();i++){
           
           // PreparedStatement ps=con.prepareStatement();
           
            ResultSet rs=st.executeQuery("SELECT count(*) AS count FROM tourist WHERE Tripname='"+tripname.get(i)+"'");
           
            
            while(rs.next()){
                Joining_tourist_snum.add(rs.getInt("count"));
                //JOptionPane.showMessageDialog(null, "count is"+ rs.getInt("count"));
            }
           
           }
          for (int i = 0;i<tripprice.size();i++)
          {
             totalProfit+= tripprice.get(i) * Joining_tourist_snum.get(i);
          }
          ToursInterface.jTextField17.setText(String.valueOf(totalProfit));
       }
           catch(Exception ex){
           JOptionPane.showMessageDialog(null,ex);
           }
   
    }
    
   public void CalculateProfitforCategory(){
   
 try
       {
            connection.setConnection();
          
           // PreparedStatement ps=con.prepareStatement();
           Statement st1=con.createStatement();
           Statement st2=con.createStatement();
           Statement st=con.createStatement();
            ResultSet rs2 = st1.executeQuery("SELECT Trip_name FROM trips WHERE Trip_category ='"+ToursInterface.jComboBox3.getSelectedItem().toString()+"'");
            ResultSet rs3 = st2.executeQuery("SELECT Trip_price FROM trips WHERE Trip_category='"+ToursInterface.jComboBox3.getSelectedItem().toString()+"'");
            ArrayList<String> tripname=new ArrayList<>();
            ArrayList<Integer> tripprice=new ArrayList<>();
            ArrayList<Integer>Joining_tourist_snum=new ArrayList<>();
            int CategoryProfit = 0;
            while(rs2.next())
            {
                tripname.add(rs2.getString("Trip_name"));
            }
             while(rs3.next())
            {
                tripprice.add(rs3.getInt("Trip_price"));
            }
            
           for(int i=0;i<tripname.size();i++){
           
           // PreparedStatement ps=con.prepareStatement();
           
            ResultSet rs=st.executeQuery("SELECT count(*) AS count FROM tourist WHERE Tripname='"+tripname.get(i)+"'");
           
            
            while(rs.next()){
                Joining_tourist_snum.add(rs.getInt("count"));
                //JOptionPane.showMessageDialog(null, "count is"+ rs.getInt("count"));
            }
           
           }
          for (int i = 0;i<tripprice.size();i++)
          {
             CategoryProfit+= tripprice.get(i) * Joining_tourist_snum.get(i);
          }
          ToursInterface.jTextField16.setText(String.valueOf(CategoryProfit));
       }
           catch(Exception ex){
           JOptionPane.showMessageDialog(null,ex);
           }
   
    }
    
  
    
    
    
}
