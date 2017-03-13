package string;

/**
 Find if a 2 strings are permutation of each other
**/
public class Permutation {

   public boolean isPermutation(String s1, String s2){
         if(s1 == null || s2 == null)
             return false;
             
          if(s1.length() != s2.length())
              return false;
           
          int[] arr = new int[128];   
          for(int i=0; i <s1.length(); i++){         
          		int c = s1.charAt(i);
                arr[c]++;          
          }   
          for(int j=0; j <s1.length(); j++){         
          		int c = s1.charAt(j);
                arr[c]--;    
                if(arr[c] < 0)
                   return false;      
          }
          
          return true;
   }
   
   public static void main(String arg[]){
   
      String s1 = "DOG";
      String s2 = "GOD";
      
      Permutation obj = new Permutation();
       System.out.println(obj.isPermutation(s1, s2));
    
   }

}
