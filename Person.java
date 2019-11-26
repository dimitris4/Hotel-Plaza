public class Person{
   //attributes
   protected String firstName;
   protected String lastName;
   protected String telNo;
   protected String address;
   protected String emailAddress;
   
   //constructors
   public Person(){
   }

   //Getters and setters   
   public String getAddress() {
      return address;
   }
   
   public void setAddress(String address) {
      this.address = address;
   }
      
   public String getFirstName() {
      return firstName;
   }
   
   public void setFirstName(String firstName) {
      this.firstName = firstName.toUpperCase();
   }
   
   public String getLastName() {
      return lastName;
   }
   
   public void setLastName(String lastName) {
      this.lastName = lastName.toUpperCase();
   }
   
   public String getTelNo() {
      return telNo;
   }
   
   public void setTelNo(String telNo) {
      this.telNo = telNo;
   }
   
   public String getEmailAddress() {
      return emailAddress;
   }
   
   public void setEmailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
   }
    
   //toString method
   @Override
   public String toString() {
      return  firstName +" "+ lastName +" "+ telNo +" "+ address;         
   }  
}