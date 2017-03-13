package string;

/**
 * Find if a given string has unique characters
 * @author suni
 *
 */
public class IsUniqueString {

public boolean isUnique(String s){

   if(s.length() > 128)
      return false;
      
    boolean arr[] = new boolean[128];  
    for(int i=0; i<s.length(); i++){
        
           int c = s.charAt(i);
           if(arr[c])
              return false;
           else
              arr[c] = true;
    
    }  
    
    return true;

}

public static void main(String arg[]){
 
      String s = "Sunithua";
      
      IsUniqueString obj = new IsUniqueString();
      System.out.println(obj.isUnique(s));

}
}
