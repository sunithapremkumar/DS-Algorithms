package recursion;

import java.util.*;
/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 * @author suni
 *
 */
public class Permutation {
public String getPermutation(int n, int k) {
        
        List<String> list = getPerms(n);
        Collections.sort(list);
        for(String s : list)
            System.out.println(s);
          return list.get(k-1);
        
    }
    
    private List<String> getPerms(int n){
        if( n==1){
            List<String> l = new ArrayList<>();
            l.add(n+"");
            return l;
        }
       List<String> list = getPerms(n-1);
       List newList = addToList(list, n); 
       return newList; 
    }
    
    private List<String> addToList(List<String> list, int n){
        List<String> newList = new ArrayList<>();
        for(String s: list){
            
            int index = 0;
            while(index <= s.length()){
                StringBuilder buf = new StringBuilder(s);
                buf.insert(index, n);
                newList.add(buf.toString());
                 index++;
            }
            
        }
        return newList;
        
    }
    
    public static void main(String arg[]){
    	Permutation s = new Permutation();
    	System.out.println(s.getPermutation(3, 4));
    }
}
