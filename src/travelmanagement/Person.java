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
 * @author Alaa Sayed
 */
public abstract  class Person {
protected int id;
protected String name;
    protected int age;
  protected  TourTrip current_Trip;

    public abstract void add();
        public abstract void edit();
        public abstract void view();
        public abstract void delete();

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCurrent_Trip(TourTrip current_Trip) {
        this.current_Trip = current_Trip;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public TourTrip getCurrent_Trip() {
        return current_Trip;
    }

   
   
    
    
}
