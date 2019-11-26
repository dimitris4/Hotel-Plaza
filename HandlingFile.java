
import java.io.*;
import java.util.*;

public class HandlingFile {


   public HandlingFile() {
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
      //System.out.println(list);
      return list;
   }
   
   public ArrayList<String> readRoomsIDFromFile() throws FileNotFoundException {
      ArrayList<Room> list = readRoomsFromFile();
      ArrayList<String> IDlist = new ArrayList<String>();
      for (int i = 0; i < list.size(); i++){
         IDlist.add(list.get(i).getRoomID());
      }
      return IDlist;
   }

   public void saveInFile(ArrayList<Room> rooms) throws FileNotFoundException {
      PrintStream file = new PrintStream(new File("rooms.txt"));
      for (int i = 0; i < rooms.size(); i++){
         file.println(rooms.get(i));
      }
      file.flush();
      file.close();
   }   
   



}