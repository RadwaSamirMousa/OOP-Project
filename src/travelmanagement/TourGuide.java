
package travelmanagement;

/**
 *
 * @author abdel
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TourGuide {
    private int Tourguideid;   
    private String Tourguidename;
    private int TourguideSalary;
    private TourTrip CurrentTrip;
    private int Tourguideage;

    public void setTourguideage(int Tourguideage) {
        this.Tourguideage = Tourguideage;
    }

    public int getTourguideage() {
        return Tourguideage;
    }

   
    public void setTourguideid(int Tourguideid) {
        this.Tourguideid = Tourguideid;
    }

    public void setTourguidename(String Tourguidename) {
        this.Tourguidename = Tourguidename;
    }

    public void setTourguideSalary(int TourguideSalary) {
        this.TourguideSalary = TourguideSalary;
    }

    public void setCurrentTrip(TourTrip CurrentTrip) {
        this.CurrentTrip = CurrentTrip;
    }

    public int getTourguideid() {
        return Tourguideid;
    }

    public String getTourguidename() {
        return Tourguidename;
    }

    public int getTourguideSalary() {
        return TourguideSalary;
    }

    public TourTrip getCurrentTrip() {
        return CurrentTrip;
    }
   

 
   public void add()
   {
      
     try {
         BufferedWriter bw=new BufferedWriter(new FileWriter("Tourguide.txt",true));
         
    bw.write(Tourguideid+"@"+Tourguidename+"@"+Tourguideage+"@"+TourguideSalary);
    bw.newLine();
       bw.close();
        JOptionPane.showMessageDialog(null,"File Written Successfull");
     } catch (IOException ex) {
         Logger.getLogger(TourGuide.class.getName()).log(Level.SEVERE, null, ex);
     }
       
   
   }
    
}
