package tries;

import java.util.*;

/**
 * We're going to make our own Contacts application! The application must perform two types of operations:

 *  1. add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
 *  2. find partial, where  is a string denoting a partial name to search the application for. It must count the number of contacts starting with
 *  and print the count on a new line.
 * @author prasunit
 *
 */
public class Contacts{
	public static class Node{
        private Node[] children = new Node[26];
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
            if(index >= s.length())
               return;
            
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
        
     
 
}  
	
    
    public static void main(String[] args) {

        Node n = new Node();
       /* n.addString("s");
        n.addString("ss");
        n.addString("sss");
        n.addString("ssss");
        n.addString("sssss");
        
        System.out.println(n.findCount("s",0));
        System.out.println(n.findCount("ss",0));
        System.out.println(n.findCount("sss",0));
        System.out.println(n.findCount("ssss",0));
        System.out.println(n.findCount("sssss",0));
        System.out.println(n.findCount("ssssss",0));
        
        */
        n.addString("hack");
        n.addString("hacker");
       // n.addString("hacker");
        System.out.println(n.findCount("hac",0));
        System.out.println(n.findCount("hak",0));
    }
}
