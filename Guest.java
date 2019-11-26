import java.util.*;
import java.io.*;

public class Guest extends Person {
         
   private String guestID = new RandomIdGenerator().getBase62(4);
   private String salutation;   
   
   //constructor
   public Guest() {}
   
   //Getters and setters
   public String getGuestID() {
      return guestID;
   }
   
   public void setGuestID(String guestID) {
      this.guestID = guestID;
   }
   
   public String getSalutation() {
      return salutation;
   }
   
   public void setSalutation(String salutation) {
      this.salutation = salutation;
   }

   //toString method
   @Override
   public String toString() {
      return  String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s",guestID, salutation, firstName, lastName, telNo, address, emailAddress);         
   }   
}