import java.util.*;


public class RandomIdGenerator {
    
    private String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private char[] base62chars = chars.toCharArray();
    
    
    //creates a random combination from 62 characters
    public String getBase62(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i=0; i<length; i++) {
            int c = random.nextInt(62);
            sb.append(base62chars[c]);
        }

        return sb.toString();
    }       
}
