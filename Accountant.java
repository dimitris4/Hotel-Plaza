import java.util.*;
import java.io.*;


public class Accountant {
   
   
   private ArrayList<Staff> staffList = new ArrayList<Staff>();
  
  
   //constructor
   public Accountant() {}
   
   
   //getter
   public ArrayList<Staff> getStaffList() {
      return staffList;
   } 
   
   //reads data from file and stores in ArrayList<Staff>
   public void setStaffList() throws FileNotFoundException {
      ArrayList<Staff> staffList = new ArrayList<Staff>();
      Scanner input = new Scanner(new File("staff.txt"));
      while (input.hasNext()) {
         Staff staff = new Staff();
         staff.setStaffID(input.next());
         staff.setTitle(input.next());
         staff.setFirstName(input.next());
         staff.setLastName(input.next());
         staff.setTelNo(input.next());
         staff.setSalary(input.next());
         staffList.add(staff);
      }
      this.staffList = staffList;
   }


   public void viewStaff() throws FileNotFoundException {
      System.out.println("HOTEL PLAZA EMPLOYEES");
      System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "Staff ID", "Title", "First Name", "Last Name", "Tel No", "Salary");
      System.out.println("***********************************************************************************************************");
      for (int i=0; i<staffList.size(); i++) {
         System.out.println(staffList.get(i));
      }
         System.out.println("==========================================================================================================="); 

   }
   
   
   
   public void addStaff() throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      Staff staff = new Staff();
      String word;
      System.out.print("Enter job title: ");
      word = console.next();
      while(!word.matches("[a-zA-Z_]+")){
         System.out.print("Invalid Title. Try Again:");
         word = console.next();
      }   
      staff.setTitle(word);
      
      System.out.print("Enter first name");
      word = console.next();
      while(!word.matches("[a-zA-Z_]+")){
         System.out.print("Invalid First Name. Try Again:");
         word = console.next();
      } 
      staff.setFirstName(word);
      
      System.out.print("Enter last name: ");
      word = console.next();
      while(!word.matches("[a-zA-Z_]+")){
         System.out.print("Invalid Last Name. Try Again:");
         word = console.next();
      } 
      staff.setLastName(word);
      
      System.out.print("Enter telephone: ");
       word = console.next();
      while(!word.matches("[0-9]+")){
         System.out.print("Invalid Telephone number. Try Again:");
         word = console.next();
      } 
      staff.setTelNo(word);
      
      System.out.print("Enter salary: ");
      word = console.next();
      while(!word.matches("[0-9]+")){
         System.out.print("Invalid Salary. Try Again:");
         word = console.next();
      } 
      staff.setSalary(word);
      
      System.out.print(staff);
      staffList.add(staff);
   }
   
   public int searchByPersonID() {
      Scanner console = new Scanner(System.in); 
      System.out.print("Please enter the employee's ID:");
      String id = console.next();
      for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getStaffID().equals(id)) {
               System.out.print(staffList.get(i));
               return i;
            }
      }
      return -1;      
   }
   
   public void editStaff() throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      int index = searchByPersonID();
      Staff staff = staffList.get(index);
      System.out.println("Select option: ");
      System.out.println("[1] Change Telephone");
      System.out.println("[2] Change Salary");
      System.out.println("[3] Cancel");
      String word;
      String option = console.next();
         switch (option) {
            case "1":
               System.out.print("Enter new Tel No: ");
               word = console.next();
                   while(!word.matches("[0-9]+")){
                     System.out.print("Invalid Telephone number. Try Again:");
                     word = console.next();
                   } 
               staff.setTelNo(word);
               break;
            case "2":
               System.out.print("Enter new Salary: ");
               word = console.next();
                while(!word.matches("[0-9]+")){
                  System.out.print("Invalid Salary. Try Again:");
                  word = console.next();
                } 
            staff.setSalary(word);
            break;
            default:
               System.out.println("Selection Incorrect");
               break; 
         }
         System.out.println("Updated: " + staff);
   }

   public void saveToFile() throws FileNotFoundException {
      PrintStream output = new PrintStream(new File("staff.txt"));
      for (int i = 0; i < staffList.size(); i++) {
         output.println(staffList.get(i));
      }
   }   
   
   public void deleteStaff() {
      int index = searchByPersonID();
      if (index != -1) {
         staffList.remove(index);
      }    
   }
}