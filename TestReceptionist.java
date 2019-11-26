import java.util.*;
import java.io.*;

public class TestReceptionist  {
   public static void main(String[] args) throws FileNotFoundException {
      Receptionist rec = new Receptionist();
      try {
         rec.createBookingList();
         rec.createGuestList();
      }
      catch (Exception e) { }
      ArrayList<Booking> list = rec.getBookingList();
      System.out.println(list);
      rec.createBooking();

   }
}