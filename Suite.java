

public class Suite extends Room{
   //attributes
   private final static int NUMBER_ON_FLOOR = 3;  // final static because it's the same for each room of type SUITE
       
   // constructor
   public Suite(String roomID){
      super(roomID);
      setRoomType(3);
      setPricePerNight(1800.0);
      setNumberOfBeds(4);
   } 
   
   public Suite(int floor){
      super(floor);
      setRoomType(3);
      setRoomID(floor, 3);
      setPricePerNight(1800.0);
      setNumberOfBeds(4);
   } 
   
   public Suite(String roomID, int roomType, boolean internetAccess, double pricePerNight, int floor){
      super(roomID, roomType, internetAccess, pricePerNight, floor);
      setPricePerNight(1800.0);
      setNumberOfBeds(4);
   }  
   
   //getters and setters
   public double getNumberOnFloor() {
      return NUMBER_ON_FLOOR;
   }
     
}

   //toString method
   /*@Override
   public String toString() {
      //return  super.toString() +", price per night: "+ pricePerNight + ", number of beds in a suite: " + NUMBER_OF_BEDS +", number on each floor: "+ NUMBER_ON_FLOOR;         
      return  super.toString();
   }*/

