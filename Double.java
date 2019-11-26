

public class Double extends Room{
   //attributes
   private final static int NUMBER_ON_FLOOR = 2;  // final static because it's the same for each room of type DOUBLE
       
   // constructor
   public Double(String roomID){
      super(roomID);
      setRoomType(2);
      setPricePerNight(1200.0);
      setNumberOfBeds(2);
   } 
   
   public Double(int floor){
      super(floor);
      setRoomType(2);
      setRoomID(floor, 2);
      setPricePerNight(1200.0);
      setNumberOfBeds(2);
   } 
   
   public Double(String roomID, int roomType, boolean internetAccess, double pricePerNight, int floor){
      super(roomID, roomType, internetAccess, pricePerNight, floor);
      setPricePerNight(1200.0);
      setNumberOfBeds(2);
   }    
   
   //getters and setters
   public double getNumberOnFloor() {
      return NUMBER_ON_FLOOR;
   }
   
    
   //toString method
   /*@Override
   public String toString() {
      //return  super.toString() +", price per night: "+ pricePerNight + ", number of beds in a double room: " + NUMBER_OF_BEDS +", number on each floor: "+ NUMBER_ON_FLOOR;         
      return  super.toString() + " " + NUMBER_OF_BEDS;
   }*/ 
} 