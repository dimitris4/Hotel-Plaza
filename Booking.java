import java.util.*;
import java.text.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class Booking {
   
   private String bookingID = new RandomIdGenerator().getBase62(5);
   private Date bookingDate = new Date();
   private Date checkInDate;
   private Date checkOutDate;
   private ArrayList<Room> rooms; 
   private double totalPrice;
   private Guest guest;
   
   public Booking() {}
   
   public Booking(String bookingID) {
      this.bookingID = bookingID;
   } 
   
   //setters   
   public void setBookingID(String bookingID) {
      this.bookingID = bookingID;
   }
   
   public void setBookingDate(Date date) {
      this.bookingDate = bookingDate;
   }
   
   public void setCheckInDate(Date checkInDate) {
      this.checkInDate = checkInDate;
   }
   
   public void setCheckOutDate(Date checkOutDate) {
      this.checkOutDate = checkOutDate;
   }
   
   public void setRooms(ArrayList<Room> rooms) {
      this.rooms = rooms;
   }
   
   public void setTotalPrice(double totalPrice) {
      this.totalPrice = totalPrice;
   }
 
   public void setGuest(Guest guest) {
      this.guest = guest;   
   }
   
   //getters   
   public String getBookingID() {
      return bookingID;
   }
   
   public Date getBookingDate() {
       return bookingDate;
   }
   
   public Date getCheckInDate() {
      return checkInDate;
   }
   
   public Date getCheckOutDate() {
      return checkOutDate;
   }
   
   public ArrayList<Room> getRooms() {
      return this.rooms;
   }
   
   public double getTotalPrice() {
      return totalPrice;
   }
     
   public Guest getGuest() {
      return this.guest;
   }
   
   //create CHECK-IN DATE
   public Date createCheckInDate() {
      System.out.print("Enter check-in date (dd/mm/yyyy): ");
      Date date = enterDate();
      while (date.compareTo(bookingDate) < 0) {
         System.out.print("Check-in day must be after " + formatDate(bookingDate) + ": ");
         date = enterDate();
      }
      this.checkInDate = date;
      return date;  
   }  
  
   //create CHECK-OUT DATE
   public Date createCheckOutDate() {
      System.out.print("Enter check-out date (dd/mm/yyyy): ");
      Date date = enterDate();
      while (date.compareTo(this.checkInDate) <= 0) {
         System.out.print("Check-out day must be after " + formatDate(checkInDate) + ": ");
         date = enterDate();
      }
      this.checkOutDate = date;
      return date;
   }
   
   public void addRooms() throws FileNotFoundException { 
      ArrayList<Room> input = readRoomsFromFile();
      ArrayList<Room> rooms = new ArrayList<Room>();
      Scanner console = new Scanner(System.in);
      boolean noMoreRoomsToBeAdded = true;
      boolean roomNotBeenSelected = true;
      int a = 0;
      String choice;
      while (noMoreRoomsToBeAdded) {
         while (roomNotBeenSelected) {
            System.out.print("Enter Room Number: ");
            choice = console.next();
            for (int i = 0; i < input.size(); i++) {
               if (input.get(i).getRoomID().equals(choice)) {
                  rooms.add(input.get(i));
                  roomNotBeenSelected = false;
                  a = -1;
                  System.out.println("Room has been selected.");
               }  
            }
            if (a != -1) {
            System.out.println("Invalid input.");
            }
         }
         System.out.print("Do you want to add more rooms? (yes/no) ");
         String answer = console.next();
         switch (answer) {
            case "yes":
               roomNotBeenSelected = true;
               a = 0;
               break;
            case "no":
               noMoreRoomsToBeAdded = false;
               break;
            default:
               System.out.println("Selection Incorrect");
               break; 
         }
      }
      this.rooms = rooms;
   }
   
   //compute Total Price
   public void computeTotalPrice() {
      double sum = 0;
      int k = numberOfDays(checkInDate, checkOutDate);
      for (int i = 0; i < rooms.size(); i++) {
         sum += rooms.get(i).getPricePerNight() * k;         
      }
      this.totalPrice = sum;
   }
 
 
   //representation of a Booking instance as a string
   public String toString() {   
      return bookingID + " " + this.guest.getFirstName() + " " + this.guest.getLastName() + " " + formatDate(bookingDate) + " " + formatDate(checkInDate) + " " +
             formatDate(checkOutDate) + " " + totalPrice + " " + formatArray(rooms);
   }
   
   
   //difference between CHECK-IN and CHECK-OUT in days
   public int numberOfDays(Date date1, Date date2) {
      long difference = Math.abs(date2.getTime() - date1.getTime());
      int numberOfDays = (int) TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
      return numberOfDays;
   }
   
   
   //takes string from console and transforms it to Date object 
   public Date enterDate() {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      Scanner console = new Scanner(System.in);
      String str = console.next();
      Date date = new Date();
      while (true) {
         try {
            date = sdf.parse(str); 
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            break;
         } catch (ParseException e) { 
            System.out.print("Day must have the following format (dd/mm/yyyy): ");
            str = console.next();
            continue;
         }
      }  
      return date; 
   }
   
   
   //converts date to string with this format: dd/mm/yyyy
   public String formatDate(Date date) {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      return sdf.format(date);
   }
   
  
   //reads Room data from a file
   public ArrayList<Room> readRoomsFromFile() throws FileNotFoundException {
      Scanner input = new Scanner(new File("rooms.txt"));
      ArrayList<Room> list = new ArrayList<Room>();
      while (input.hasNext()) {
         Room room = new Room();
         room.setRoomID(input.next());
         room.setRoomStatus(input.nextBoolean());
         room.setRoomType(input.nextInt());
         room.setInternetAccess(input.nextBoolean());
         room.setFloor(input.nextInt());
         room.setPricePerNight(input.nextDouble());
         room.setNumberOfBeds(input.nextInt());
         list.add(room);
      }
      return list;
   }


   //extends CHECK-OUT date by number of days   
   public void extendBooking() {
      System.out.print("Number of days you want to extent the booking: ");
      Scanner console = new Scanner(System.in);
      int choice = 0;
      String string = "";
      boolean notAnInteger = true;
      while(notAnInteger){
         string = console.next();
         try {
            choice = Integer.parseInt(string);
            notAnInteger = false;
         } catch(Exception e) {
            System.out.print("Invalid input. Try again: ");
         }
      }
      Calendar cal = Calendar.getInstance();
      cal.setTime(checkOutDate);
      cal.add(Calendar.DATE, choice);  
      checkOutDate = cal.getTime();
      double sum = 0.0;
      for (int i = 0; i < rooms.size(); i++) {
         sum += rooms.get(i).getPricePerNight() * choice;         
      }
      totalPrice += sum;
   }
   
   //removes brackets and commas from the ArrayList representation as a string.
   public StringBuilder formatArray(ArrayList<Room> rooms) {
      StringBuilder builder = new StringBuilder();
      for (Room room : rooms) {
         builder.append(room);
      }
      return builder;
   }
   
   public ArrayList<String> printRoomNumbers() {
      ArrayList<String> list = new ArrayList<String>();
      Room room = new Room();
      for (int i = 0; i < rooms.size(); i++) {
         list.add(rooms.get(i).getRoomID());
      }
      return list;
   } 
}