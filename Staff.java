import java.util.*;
import java.io.*;

public class Staff extends Person {
   
   private String staffID = new RandomIdGenerator().getBase62(4);
   private String title;
   private String salary;
   
   public String getStaffID() {
      return staffID;
   }
   
   public void setStaffID(String staffID) {
      this.staffID = staffID;
   }

   public String getTitle() {
      return title;
   }
   
   public void setTitle(String title) {
      this.title = title;
   }
      
   public String getSalary() {
      return salary;
   }
   
   public void setSalary(String salary) {
      this.salary = salary;
   }
   
   //Empty Constructor
   public Staff(){}

   //to-string 
   public String toString() {   
      return String.format("%-20s%-20s%-20s%-20s%-20s%-20s", staffID, title, firstName, lastName, telNo, salary);
   }
}