

public class Single extends Room{
   //attributes
   private final static int NUMBER_ON_FLOOR = 1;  // final static because it's the same for each room of type SINGLE
      
   // constructor
   public Single(String roomID){
      super(roomID);
      setRoomType(1);
      setPricePerNight(1000.0);
      setNumberOfBeds(1);
   } 
   
   public Single(int floor){
      super(floor);
      setRoomType(1);
      setRoomID(floor, 1);
      setPricePerNight(1000.0);
      setNumberOfBeds(1);
   } 

   public Single(String roomID, int roomType, boolean internetAccess, double pricePerNight, int floor){
      super(roomID, roomType, internetAccess, pricePerNight, floor);
      setPricePerNight(1000.0);
      setNumberOfBeds(1);
   }    
   
   //getters and setters
   public double getNumberOnFloor() {
      return NUMBER_ON_FLOOR;
   }
   
    
   //toString method
   /*@Override
   public String toString() {
      //return  super.toString() +", price per night: "+ pricePerNight + ", number of beds in a single room: " + NUMBER_OF_BEDS +", number on each floor: "+ NUMBER_ON_FLOOR;         
      return  super.toString() + " " + NUMBER_OF_BEDS;
   }*/ 
} 