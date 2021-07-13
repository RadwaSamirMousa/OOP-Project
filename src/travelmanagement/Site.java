/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelmanagement;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author abdel
 */
public class Site{
    private String site_name;
    private String site_category;

    public String getSite_name() {
        return site_name;
    }

    public String getSite_category() {
        return site_category;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public void setSite_category(String site_category) {
        this.site_category = site_category;
    }
    
    public void add(){
         try{
                connection.setConnection();
            connection.runNoNQuery("insert into site (Sitename,Sitedescription) values('"+ToursInterface.jTextField12.getText()+"','"+ToursInterface.jTextField13.getText()+"')");
            JOptionPane.showMessageDialog(null,"ADD successfully");
            }
            catch(Exception ex){
               JOptionPane.showMessageDialog(null,"Erorr in connection");
            }
    }
    
 
}
