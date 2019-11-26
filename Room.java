

public class Room {
   
   private String roomID; // I change roomID to String as I use the concatenation to join int floor and int roomType together; Let me know if it make sense for you.
   private boolean roomStatus; // I would change the name "roomStatus" for "availability". I think it makes more sense while it's true or false :)
   private int roomType; // I assign this value in the subclasses
   private boolean internetAccess;
   private double pricePerNight; // I assign this value in the subclasses
   private int floor;
   private int numberOfBeds; // I assign this value in the subclasses
   
   
   //constructors
   public Room() {
      roomStatus = true;
      internetAccess = true;
   }
   
   public Room(String roomID) {
      roomStatus = true;
      internetAccess = true;
      this.roomID = roomID;
   }
   
   public Room(int floor) {
      roomStatus = true;
      internetAccess = true;
      this.floor = floor;
   }   
   
   public Room(String roomID, int roomType, boolean internetAccess, double pricePerNight, int floor) {
      roomStatus = true;
      this.roomID = roomID;
      this.roomType = roomType;
      this.internetAccess = internetAccess;
      this.pricePerNight = pricePerNight;
      this.floor = floor;
   }
   
   //getters and setters
   public String getRoomID() {
      return roomID;
   }
   public void setRoomID(String roomID) {
      this.roomID = roomID; 
   }
   public void setRoomID(int floor, int roomType) {
      this.roomID =  " "+ String.valueOf(floor) + String.valueOf(roomType); 
   }
   public boolean getRoomStatus() {
      return roomStatus;
   }
   public void setRoomStatus(boolean roomStatus) {
      this.roomStatus = roomStatus;
   }
   public int getRoomType() {
      return roomType;
   }
   public void setRoomType(int roomType) {
      this.roomType = roomType;
   }
   public boolean getInternetAccess() {
      return internetAccess;
   }
   public void setInternetAccess(boolean internetAccess) {
      this.internetAccess = internetAccess;
   }
   public double getPricePerNight() {
      return pricePerNight;
   }
   public void setPricePerNight(double pricePerNight) {
      this.pricePerNight = pricePerNight;
   }
   public int getFloor() {
      return floor;
   }
   public void setFloor(int floor){
      this.floor = floor;
   }
   public int getNumberOfBeds() {
      return numberOfBeds;
   }
   public void setNumberOfBeds(int numberOfBeds){
      this.numberOfBeds = numberOfBeds;
   }
   
   //editing room's price method
   /*public double editRooomPrice() {
      System.out.print("Enter new price: ");
      Scanner console = new Scanner (System.in);
      double price = 1000.0;
      if (console.hasNextDouble()){
         price = console.nextDouble();
      } else if (console.hasNextInt()){
         price = console.nextInt();   
      } else {
         System.out.println("It wasn't a number.");
         System.out.println("Try again. ");
         price = editRooomPrice();
      }
      this.pricePerNight = price;
      return price;
   }*/   
   
   //toString method
   @Override
   public String toString() {
      //return  "Room's ID is: " + roomID +", status: "+ roomStatus +", type: "+ roomType +", internet access: "+ internetAccess + ", located on floor no."+ floor;         
      return  roomID + " " + roomStatus + " " + roomType + " " + internetAccess + " " + floor + " " + pricePerNight + " " + numberOfBeds + " ";
   }

  
}