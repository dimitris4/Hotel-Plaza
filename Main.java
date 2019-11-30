import java.util.*;
import java.io.*;
import java.nio.*;

public class Main {

   public static void main(String[] args) throws FileNotFoundException, IOException {
      login();  
   }
   
   public static void login() throws FileNotFoundException, IOException {
      System.out.print("Please enter password to login: ");
      Scanner console = new Scanner(System.in);
      String input = console.next();
      while ((!input.equals("acc")) && (!input.equals("rec"))) {
         System.out.println("Wrong password! Please enter password to login:");
         input = console.next();
      }
      switch (input) {
         case "rec":
            displayMainMenu();
            break;
         case "acc":
            displayStaff();
            break;   
      }
   }
    
   public static void displayMainMenu() throws FileNotFoundException {   
      while (true) {
         System.out.println("*****************************************");
         System.out.println("|             HOTEL PLAZA               |");
         System.out.println("*****************************************");
         System.out.println("| Options:                              |");
         System.out.println("|        1. Manage Rooms                |");
         System.out.println("|        2. Manage Guests               |");
         System.out.println("|        3. Manage Bookings             |");
         System.out.println("|        4. Exit                        |");
         System.out.println("*****************************************");
         System.out.print("Select option: "); 
         Scanner console = new Scanner(System.in);
         String option = console.next();
         switch (option) {
            case "1":
               displayRooms();
               break;
            case "2":
               displayGuests();
               break;
            case "3":
               displayBookings();
               break;
            case "4": 
               System.exit(0);
            default:
               System.out.println("Selection Incorrect");
               break; 
         }
      }    
   }
    
   public static void displayRooms() throws FileNotFoundException {   
      while (true) {
         Scanner console = new Scanner(System.in);
         Receptionist receptionist = new Receptionist();
         System.out.println("*****************************************");
         System.out.println("|                ROOMS                  |");
         System.out.println("****************************************|");
         System.out.println("| Options:                              |");
         System.out.println("|        1. View Rooms                  |");
         System.out.println("|        2. Add New Room                |");
         System.out.println("|        3. Change Room Price           |");
         System.out.println("|        4. Delete Room                 |");
         System.out.println("|        5. Back to Main Menu           |");
         System.out.println("|        6. Exit                        |");
         System.out.println("***************************************");
         System.out.print("Select option: "); 
         String option = console.next();
         switch (option) {
            case "1":
               receptionist.viewRooms();
               pressEnter();
               displayRooms();
               break;
            case "2":
               receptionist.createNewRoom();
               pressEnter();
               displayRooms();
               break;
            case "3":
               receptionist.editRoomPrice();
               pressEnter();
               displayRooms();
               break;
            case "4":
               receptionist.deleteRoom();
               pressEnter();
               receptionist.viewRooms();
               pressEnter();
               displayRooms();
               break;
            case "5": 
               displayMainMenu();
            case "6":
               System.exit(0);
            default:
               System.out.println("Selection Incorrect");
               System.out.println("Select option: ");
               displayRooms();
               break;  
         }
      }    
   }
    
   public static void displayGuests() throws FileNotFoundException {            
      while (true) {
         Scanner console = new Scanner(System.in);
         Receptionist receptionist = new Receptionist();
         receptionist.createGuestList();
         System.out.println("*****************************************");
         System.out.println("|               GUESTS                  |");
         System.out.println("*****************************************");
         System.out.println("| Options:                              |");
         System.out.println("|        1. View Guests                 |");
         System.out.println("|        2. Add New Guest               |");
         System.out.println("|        3. Delete Guest                |");
         System.out.println("|        4. Edit Guest Data             |");
         System.out.println("|        5. Back to Main Menu           |");
         System.out.println("|        6. Exit                        |");
         System.out.println("*****************************************");
         System.out.print("Select option: "); 
         String option = console.next();
         switch (option) {
            case "1":
               receptionist.viewGuest();
               pressEnter();
               break;
            case "2":
               receptionist.addGuest();
               receptionist.saveGuestsToFile();
               pressEnter();
               break;
            case "3":
               receptionist.deleteGuest();
               pressEnter();
               break;
            case "4":
               receptionist.editGuest();
               receptionist.saveGuestsToFile();
               pressEnter();
               break;
            case "5":
               receptionist.saveGuestsToFile();
               displayMainMenu();
            case "6":
               receptionist.saveGuestsToFile();
               System.exit(0);
            default:
               System.out.println("Selection Incorrect");
               break; 
         }
      }    
   }
    
   public static void displayBookings() throws FileNotFoundException {      
      while (true) {
         Receptionist receptionist = new Receptionist();
         try {
         receptionist.createBookingList();
         receptionist.createGuestList();
         } catch (Exception ex) {}
         Scanner console = new Scanner(System.in);    
         System.out.println("*****************************************");
         System.out.println("|               BOOKINGS                |");
         System.out.println("*****************************************");
         System.out.println("| Options:                              |");
         System.out.println("|        1. Create New Booking          |");
         System.out.println("|        2. Check-in                    |");
         System.out.println("|        3. Check-out                   |");
         System.out.println("|        4. Search Bookings             |");
         System.out.println("|        5. Extend Booking              |");
         System.out.println("|        6. Cancel Booking              |");
         System.out.println("|        7. Print Receipt               |");
         System.out.println("|        8. Back to Main Menu           |");
         System.out.println("|        9. Exit                        |");
         System.out.println("*****************************************");
         System.out.print("Select option: "); 
         String option = console.next();
         switch (option) {
            case "1":
               receptionist.createBooking();
               receptionist.saveBookingsToFile();
               receptionist.saveGuestsToFile();
               pressEnter();
               break;
            case "2":
               receptionist.checkIn();
               receptionist.saveBookingsToFile();
               pressEnter();
               break;
            case "3":
               receptionist.checkOut();
               receptionist.saveBookingsToFile();
               pressEnter();
               break;
            case "4":
               displaySearchBookingsMenu();
               break;
            case "5":
               receptionist.extendBooking(); 
               receptionist.saveBookingsToFile();
               pressEnter(); 
               break;
            case "6": 
               receptionist.cancelBooking();            
               receptionist.saveBookingsToFile();
               pressEnter();
               break;
            case "7":
               receptionist.printReceipt(); 
               pressEnter();
               break;
            case "8":
               displayMainMenu();
               break;
            case "9":
               receptionist.saveBookingsToFile();
               System.exit(0);
            default:
               System.out.println("Selection Incorrect");
               break; 
         }
      }    
   }
    
   public static void displayStaff() throws FileNotFoundException {
      while (true) {
         Scanner console = new Scanner(System.in);  
         Accountant accountant = new Accountant();
         accountant.setStaffList();
         System.out.println("*****************************************");
         System.out.println("|               STAFF                   |");
         System.out.println("*****************************************");
         System.out.println("| Options:                              |");
         System.out.println("|        1. View Staff                  |");
         System.out.println("|        2. Add Staff                   |");
         System.out.println("|        3. Edit Staff                  |");
         System.out.println("|        4. Delete Staff                |");
         System.out.println("|        5. Exit                        |");
         System.out.println("*****************************************");
         System.out.print("Select option: "); 
         String option = console.next();
         switch (option) {
            case "1":
               accountant.viewStaff();
               pressEnter();
               break;
            case "2":
               accountant.addStaff();
               pressEnter();
               break;
            case "3":
               accountant.editStaff();
               pressEnter();
               break;
            case "4":
               accountant.deleteStaff();
               pressEnter();
               break;
            case "5":
               accountant.saveToFile();
               System.exit(0);
               break;
            default:
               System.out.println("Selection Incorrect");
               System.out.print("Select option: ");
               break; 
         }
      } 
   }

   public static void displaySearchBookingsMenu() throws FileNotFoundException {   
      Receptionist receptionist = new Receptionist();
      try {
      receptionist.createBookingList();
      } catch (Exception ex) {} 
      Scanner console = new Scanner(System.in);
      while (true) {
         System.out.println("*****************************************");
         System.out.println("|            SEARCH BOOKINGS            |");
         System.out.println("*****************************************");
         System.out.println("| Options:                              |");
         System.out.println("|        1. Search by Booking ID        |");
         System.out.println("|        2. Search by Check-in Date     |");
         System.out.println("|        3. Search by Check-out Date    |");
         System.out.println("|        4. Search by Guest Name        |");
         System.out.println("|        5. Back to Bookings Menu       |");
         System.out.println("|        6. Exit                        |");
         System.out.println("*****************************************");
         System.out.print("Select option: ");
         String option = console.next();
         switch (option) {
            case "1":
               receptionist.searchByBookingIDMenu();
               pressEnter();
               break;
            case "2":
               receptionist.searchByCheckInDateMenu();
               pressEnter();
               break;
            case "3":
               receptionist.searchByCheckOutDateMenu();
               pressEnter();
               break;
            case "4":
               receptionist.searchByGuestName();
               pressEnter();
               break;
            case "5":
               displayBookings();
               break;
            case "6": 
               receptionist.saveBookingsToFile();
               System.exit(0);
               break;
            default:
               System.out.println("Selection Incorrect");
               break; 
         }
      }    
   }
   
   public static void pressEnter() {
      System.out.println();
      System.out.println("'Enter' to continue");
      Scanner scanner = new Scanner(System.in);
      scanner.nextLine();
   }
}