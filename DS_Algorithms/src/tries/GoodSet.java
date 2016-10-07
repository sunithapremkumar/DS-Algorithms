package tries;

import java.util.ArrayList;
import java.util.List;

import tries.Contacts.Node;

/**
 * Given  strings. Each string contains only lowercase letters from (both inclusive). The set of  strings is said to be GOOD SET if no string is prefix of another string else, it is BAD SET. (If two strings are identical, they are considered prefixes of each other.)

For example, aab, abcde, aabcd is BAD SET because aab is prefix of aabcd.

Print GOOD SET if it satisfies the problem requirement. 
Else, print BAD SET and the first string for which the condition fails.
 * @author prasunit
 *
 */
public class GoodSet {
	
	public static class Node{
        private Node[] children = new Node[10];
        private boolean isCompleteNode = false;
        private int size = 0;  //Stores the number of complete words under this node
        public Node(){
        }
        private int getIndex(char c){
            return (c-'a');
        }
       
        public void setNode(int index, Node n){         
            children[index] = n;
        }
        
        public Node getNode(char c){
            return children[getIndex(c)];
        }
        //constructing the trie
        public void addString(String s){
            addString(s, 0);
        }
        public void addString(String s, int index){
        	 size++; // every time the node is visited, the count of words passing thru that node increases.
            if(index == s.length()){	
               isCompleteNode =true;
               return;
            }
            char c = s.charAt(index);
            Node n = getNode(c);
            if(n == null){
                int i = getIndex(c);
                n = new Node();
                setNode(i, n);
            }
            n.addString(s, index+1);
        }
        //Finding 	the partial word in the trie
        public int findCount(String s, int index){
            if(index == s.length())
                return size;
             char c = s.charAt(index);
             Node n = getNode(c);
             if(n == null)
                return 0;
             else
                return n.findCount(s, index+1);
        }
        
        public boolean isGoodString(String s, int index){
            if(index == s.length())
                return true;
             char c = s.charAt(index);
             Node n = getNode(c);
             if(n.isCompleteNode && (index < s.length()-1)){
                 System.out.println(n.isCompleteNode + ":" + s + " index: " + index);
                 
                return false;
             }
             else
                return n.isGoodString(s, index+1);
        }
 
}  
	
	   public static List<String> isValidSet(String[] words){
	         Node n = new Node();
	         for(String s : words)
	            n.addString(s);
	         
	         ArrayList<String> badStrings = new ArrayList<String>();
	         boolean goodSet = true;
	           for(String s : words){
	        	   if(s == null || s.length() == 0)
	        		   continue;
	             if(!n.isGoodString(s, 0)){
	                 goodSet= false;
	                 badStrings.add(s);
	             }
	           }
	         return badStrings;
	           
	     }
	    public static void main(String[] args) {
	       String[] words = {"aab","defgab","abcde","aabcde","cedaaa", "bbbbbbbbbb", "jabjjjad"}; //{"aab","abcde", "aabcd" };
	        List<String> badStrs = isValidSet(words) ;
	        if(badStrs.size() == 0)
	         System.out.println("GOOD SET");
	        else{
	         System.out.println("BAD SET");
	         for(String bad: badStrs)
	            System.out.println(bad);

	        }
	    }

}
